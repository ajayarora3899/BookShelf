package com.ajay.projects;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChooseAdmin")
public class ChooseAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
			String q2 = req.getParameter("radio");
			
			if(q2.compareTo("Add")==0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("Add.jsp");
				rd.forward(req, res);
			}
			else if(q2.compareTo("Remove")==0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("Remove.jsp");
				rd.forward(req, res);
			}
	
			else if(q2.compareTo("Update")==0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, res);
			}
	
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("AdminView.jsp");
				rd.forward(req, res);
			
			}	}
}
