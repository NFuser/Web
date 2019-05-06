package com.twly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twly.server.UserServer;

@WebServlet("/ActivateServlet")
public class ActivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//点击激活连接后跳转激活后台
		request.setCharacterEncoding("utf-8");
		String activation="";
		activation=request.getParameter("activation").toString();
		//先获取页面的激活码
		boolean result=service.is_Activate(activation);
		//用从前台页面获取的激活码进行激活操作
		if(result)
			//如存在此激活码，则激活成功
			response.sendRedirect("/xxxx/activate.html");
		else
			//如不存在此激活码，则激活失败
			response.sendRedirect("/xxxx/activateFail.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
