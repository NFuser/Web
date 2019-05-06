package com.twly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twly.entity.GameUser;
import com.twly.server.UserServer;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServer service=new UserServer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		if(request.getSession().getAttribute("id")==null){
			response.sendRedirect("/xxxx/sessionOut.html");
			return;
		}
		String username="";
		String is_del="";
		String is_activate="";
		String is_admin="";
		Map<String,Object> map=new HashMap<String,Object>();
		//用户名
		if(request.getParameter("username")!=null
				&&!"".equals(request.getParameter("username"))){
			map.put("username", request.getParameter("username"));
			username=request.getParameter("username").toString();
			
		}
		//是否删除
		if(request.getParameter("is_del")!=null
				&&!"".equals(request.getParameter("is_del"))){
			map.put("is_del", request.getParameter("is_del"));
			is_del=request.getParameter("is_del").toString();
		}
		//是否激活
		if(request.getParameter("is_activate")!=null
				&&!"".equals(request.getParameter("is_activate"))){
			map.put("is_activate", request.getParameter("is_activate"));
			is_activate=request.getParameter("is_activate").toString();
		}
		//是否为管理员
		if(request.getParameter("is_admin")!=null
				&&!"".equals(request.getParameter("is_admin"))){
			map.put("is_admin", request.getParameter("is_admin"));
			is_admin=request.getParameter("is_admin").toString();
		}
		List<GameUser> list=new ArrayList<GameUser>();
		list=service.getList(map);
		request.setAttribute("username", username);
		request.setAttribute("is_del", is_del);
		request.setAttribute("is_activate", is_activate);
		request.setAttribute("is_admin", is_admin);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/management.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
