package com.twly.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twly.entity.GameUser;
import com.twly.server.UserServer;
import com.twly.util.MD5Utils;
import com.twly.util.MailUtils;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("/xxxx/registration.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从前台接收注册页form表单数据并存入数据库
		request.setCharacterEncoding("utf-8");
		String username="";
		String password="";
		String mail="";
		if(request.getParameter("username")!=null){
			username=request.getParameter("username").toString();
		}//如用户名已存在也失败
		if(request.getParameter("password")!=null){
			password=request.getParameter("password").toString();
		}
		if(request.getParameter("mail")!=null){
			mail=request.getParameter("mail").toString();
		}
		//前台数据如不为空则获取
		GameUser user=new GameUser();
		//创建一个实例对象来存数据
		String userid=UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String activation=UUID.randomUUID().toString().replace("-", "").toLowerCase();
		//userid、activation用UUID随机生成并省略“-”，使其为一个连续的字符串
		user.setUserId(userid);
		user.setUsername(username);
		user.setPassword(MD5Utils.md5(password));
		//密码加密存储，密码验证时也需要先加密再对比
		user.setMail(mail);
		user.setActivation(activation);
		boolean result=service.registe(user);
		//判断是否注册成功，成功则向目标邮箱发送附带激活码的链接
		if(result){
			try {
				String msg="注册成功,点击链接进行激活:"
						+ "http://127.0.0.1:8080/xxxx/ActivateServlet?activation="
						+ activation;
				MailUtils.sendMail(mail, msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//发送邮件后跳转登录页
			response.sendRedirect("/xxxx/login.html");
		}else{
			//如注册失败，跳转操作失败页
			response.sendRedirect("/xxxx/error.html");
		}
	}
}
