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
		//����������Ӻ���ת�����̨
		request.setCharacterEncoding("utf-8");
		String activation="";
		activation=request.getParameter("activation").toString();
		//�Ȼ�ȡҳ��ļ�����
		boolean result=service.is_Activate(activation);
		//�ô�ǰ̨ҳ���ȡ�ļ�������м������
		if(result)
			//����ڴ˼����룬�򼤻�ɹ�
			response.sendRedirect("/xxxx/activate.html");
		else
			//�粻���ڴ˼����룬�򼤻�ʧ��
			response.sendRedirect("/xxxx/activateFail.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
