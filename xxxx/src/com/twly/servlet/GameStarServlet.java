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
		//通过session取到id   通过id取整个对象
		request.setCharacterEncoding("utf-8");
		String id="";
		if(request.getSession().getAttribute("id")!=null)
			id=request.getSession().getAttribute("id").toString();
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
			//跳转游戏页面
			request.getRequestDispatcher("/2048.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");		
		//把2048前台form表单传过来的数据进行处理
		int score = 0;		
		String id = "";  
		if (request.getParameter("score") != null) {
			score = Integer.parseInt(request.getParameter("score"));
		}
		if (request.getParameter("id") != null) {
			id = request.getParameter("id").toString();
		}
		//前台数据如不为空则获取
		boolean result = service.saveScoreById(id, score);
		//存储新分数检测
		if (result) {
//			request.getSession().setAttribute("id",id );
//			response.sendRedirect("/xxxx/2048.jsp?id="+id);
			response.sendRedirect("/xxxx/GameStarServlet");
		} else {
			//如存储失败，则清空Session容器id键值并跳转存储失败页面
			request.getSession().removeAttribute("id");
			response.sendRedirect("/xxxx/saveScoreFail.html");
		}
	}
}
