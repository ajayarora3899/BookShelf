package com.ajay.projects;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Welcome extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		String q2 = req.getParameter("radio");
		
		if(q2.compareTo("admin")==0)
		{
			RequestDispatcher rd1=req.getRequestDispatcher("LoginAdmin.jsp");
			rd1.forward(req, res);
		}
		if(q2.compareTo("user")==0)
		{
			RequestDispatcher rd2=req.getRequestDispatcher("LoginUser.jsp");
			rd2.forward(req, res);
		}
	}
}
