package com.ajay.projects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String uname=null;
		uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		if(uname.contentEquals("admin") && pass.contentEquals("admin"))
		{
			HttpSession session=req.getSession();
			session.setAttribute("username", uname);
			res.sendRedirect("ChooseAdmin.jsp");
		}
		else {
			res.sendRedirect("LoginAdmin.jsp");
		}
	}
}
