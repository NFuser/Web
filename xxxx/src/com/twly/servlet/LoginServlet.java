package com.twly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twly.entity.GameUser;
import com.twly.server.UserServer;
import com.twly.util.MD5Utils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从前台接收登录页form表单数据并和数据库信息比对
		request.setCharacterEncoding("utf-8");
		String username="";
		String password="";
		if(request.getParameter("username")!=null){
			username=request.getParameter("username").toString();
		}
		if(request.getParameter("password")!=null){
			password=MD5Utils.md5(request.getParameter("password").toString());
		}
		//前台数据如不为空则获取，获取的密码需加密处理以便和数据库加密之后的密码比对
		boolean uname=service.checkusername(username);
		//先检查用户名是否存在
		if(uname) {
			boolean upass=service.login(username).equals(password);
			//如用户名存在则检查密码是否正确
			if(upass) {
				boolean uis_activate=service.is_Activate_yn(username);
				//如密码正确，则检查激活状态
				if(uis_activate) {
					//如已激活，则登录
					String userid="";
					//通过username查询id
					userid=service.userid(username);
					//用Session容器记录用户id，id值为userid
					request.getSession().setAttribute("id",userid );
					GameUser user=new GameUser();
					user=service.userById(userid);
					//用刚获取的userid获取user对象
					if(user.getIs_admin()==1) {
						//如果为管理员账号，进入选择页面
						response.sendRedirect("/xxxx/admin.html");
					}else {
					//记录id后跳转游戏页面
					response.sendRedirect("/xxxx/GameStarServlet");
					}
				}else {
					//未激活，跳转未激活页面
					response.sendRedirect("/xxxx/loginNotactivated.html");
				}
			}else
				//密码错误，跳转密码错误页面
				response.sendRedirect("/xxxx/loginFailpassword.html");
		}
		else {
			//用户名不存在，跳转用户名错误页面
			response.sendRedirect("/xxxx/loginFailusername.html");
		}
	}
}
