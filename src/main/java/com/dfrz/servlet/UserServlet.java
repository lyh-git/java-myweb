package com.dfrz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfrz.beans.User;
import com.dfrz.dao.UserDao;
import com.dfrz.dao.impl.UserImpl;

import com.dfrz.beans.User;
/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello java UserServlet");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		System.out.println("uname="+uname+"upass="+upass);
//		if(uname!=null&&uname.equals("superman")&&upass.equals("666")) {
//			System.out.println(uname+"登录成功");
//			request.getRequestDispatcher("index.html");
//			
//		}else {
//			System.out.println("登录不成功");
//			response.sendRedirect("long.html");
//		}
		UserDao userdao = new UserImpl();
		boolean result=userdao.login(new User(uname, upass));
		if (result) {
			request.getRequestDispatcher("hello.html").forward(request, response);;
		}else {
			System.out.println("登录不成功");
			response.sendRedirect("login.html");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
