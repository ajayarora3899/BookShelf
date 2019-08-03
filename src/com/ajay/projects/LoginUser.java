package com.ajay.projects;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String username="user";
		String q2 = req.getParameter("radio");
		
		HttpSession session=req.getSession();
		
		
		if(username.length()!=0 && q2.compareTo("ISSUE")==0)
		{
			session.setAttribute("username", username);
			res.sendRedirect("Issue.jsp");
			
		}
		else if(username.length()!=0 && q2.compareTo("RETURN")==0)
		{
			session.setAttribute("username", username);
			res.sendRedirect("ReturnUser.jsp");
		}
		else
		{
			res.sendRedirect("LoginUser.jsp");
		}
	}
}
