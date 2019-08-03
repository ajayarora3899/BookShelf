package com.ajay.projects;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutUser")
public class LogoutUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("Welcome.html");
	}
}
