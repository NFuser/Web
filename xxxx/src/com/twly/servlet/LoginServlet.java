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
		//��ǰ̨���յ�¼ҳform�����ݲ������ݿ���Ϣ�ȶ�
		request.setCharacterEncoding("utf-8");
		String username="";
		String password="";
		if(request.getParameter("username")!=null){
			username=request.getParameter("username").toString();
		}
		if(request.getParameter("password")!=null){
			password=MD5Utils.md5(request.getParameter("password").toString());
		}
		//ǰ̨�����粻Ϊ�����ȡ����ȡ����������ܴ����Ա�����ݿ����֮�������ȶ�
		boolean uname=service.checkusername(username);
		//�ȼ���û����Ƿ����
		if(uname) {
			boolean upass=service.login(username).equals(password);
			//���û����������������Ƿ���ȷ
			if(upass) {
				boolean uis_activate=service.is_Activate_yn(username);
				//��������ȷ�����鼤��״̬
				if(uis_activate) {
					//���Ѽ�����¼
					String userid="";
					//ͨ��username��ѯid
					userid=service.userid(username);
					//��Session������¼�û�id��idֵΪuserid
					request.getSession().setAttribute("id",userid );
					GameUser user=new GameUser();
					user=service.userById(userid);
					//�øջ�ȡ��userid��ȡuser����
					if(user.getIs_admin()==1) {
						//���Ϊ����Ա�˺ţ�����ѡ��ҳ��
						response.sendRedirect("/xxxx/admin.html");
					}else {
					//��¼id����ת��Ϸҳ��
					response.sendRedirect("/xxxx/GameStarServlet");
					}
				}else {
					//δ�����תδ����ҳ��
					response.sendRedirect("/xxxx/loginNotactivated.html");
				}
			}else
				//���������ת�������ҳ��
				response.sendRedirect("/xxxx/loginFailpassword.html");
		}
		else {
			//�û��������ڣ���ת�û�������ҳ��
			response.sendRedirect("/xxxx/loginFailusername.html");
		}
	}
}
