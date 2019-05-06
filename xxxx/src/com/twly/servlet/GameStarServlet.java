package com.twly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twly.entity.GameUser;
import com.twly.server.UserServer;

/**
 * Servlet implementation class GameStarServlet
 */
@WebServlet("/GameStarServlet")
public class GameStarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameStarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ͨ��sessionȡ��id   ͨ��idȡ��������
		request.setCharacterEncoding("utf-8");
		String id="";
		if(request.getSession().getAttribute("id")!=null)
			id=request.getSession().getAttribute("id").toString();
		//��session��ȡid���粻Ϊ�����ȡ
		GameUser user=new GameUser();
		user=service.userById(id);
		//ͨ��id��ȡ����������
		if(id==null||id.equals("")) {
			//���idΪ�ջ�null�����¼��ʱ����ת��¼ҳ��
			response.sendRedirect("/xxxx/sessionOut.html");
		}else if(user.getIs_del()==1){
			//����˺�״̬�쳣����ת�˺��쳣ҳ��
			response.sendRedirect("/xxxx/loginIs_del.html");
		}else {
			//��ɹ�ȡ��user������session�ݴ����
			request.setAttribute("user", user);
			//��ת��Ϸҳ��
			request.getRequestDispatcher("/2048.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");		
		//��2048ǰ̨form�������������ݽ��д���
		int score = 0;		
		String id = "";  
		if (request.getParameter("score") != null) {
			score = Integer.parseInt(request.getParameter("score"));
		}
		if (request.getParameter("id") != null) {
			id = request.getParameter("id").toString();
		}
		//ǰ̨�����粻Ϊ�����ȡ
		boolean result = service.saveScoreById(id, score);
		//�洢�·������
		if (result) {
//			request.getSession().setAttribute("id",id );
//			response.sendRedirect("/xxxx/2048.jsp?id="+id);
			response.sendRedirect("/xxxx/GameStarServlet");
		} else {
			//��洢ʧ�ܣ������Session����id��ֵ����ת�洢ʧ��ҳ��
			request.getSession().removeAttribute("id");
			response.sendRedirect("/xxxx/saveScoreFail.html");
		}
	}
}
