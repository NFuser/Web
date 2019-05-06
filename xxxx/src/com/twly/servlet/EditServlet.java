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

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id="";
		if(request.getParameter("userid")!=null)
			id=request.getParameter("userid").toString();
		//从session获取id，如不为空则获取
		GameUser user=new GameUser();
		user=service.userById(id);
		//通过id获取对象操作检测
		if(id==null||id.equals("")) {
			//如果id为空或null，则登录超时，跳转登录页面
			response.sendRedirect("/xxxx/sessionOut.html");
		}else if(user.getIs_del()==1){
			//如果账号状态异常，跳转账号异常页面
			response.sendRedirect("/xxxx/loginIs_del.html");
		}else {
			//如成功取到user，则用session暂存对象
			request.setAttribute("user", user);
			request.getRequestDispatcher("/revise.jsp").forward(request, response);
//			response.sendRedirect("/xxxx/revise.jsp");
		}
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id="";
		if(request.getParameter("userid")!=null){
			id=request.getParameter("userid");
		}
		String password="";
		if(request.getParameter("password")!=null){
			password=MD5Utils.md5(request.getParameter("password"));
		}
		String mail="";
		if(request.getParameter("mail")!=null){
			mail=request.getParameter("mail");
		}
		int is_del=2;
		if(request.getParameter("is_del")!=null){
			is_del=Integer.parseInt(request.getParameter("is_del"));
		}
		int is_activate=2;
		if(request.getParameter("is_activate")!=null){
			is_activate=Integer.parseInt(request.getParameter("is_activate"));
		}
		int is_admin=2;
		if(request.getParameter("is_admin")!=null){
			is_admin=Integer.parseInt(request.getParameter("is_admin"));
		}
		
		GameUser user=new GameUser();
		user.setPassword(password);
		user.setUserId(id);
		user.setMail(mail);
		user.setIs_del(is_del);
		user.setIs_Activate(is_activate);
		user.setIs_admin(is_admin);
		boolean result=service.updateByUser(user);
		if(result) {
			response.sendRedirect("/xxxx/ListServlet");
		}else {
			response.sendRedirect("/xxxx/error.html");
		}
	}
}
