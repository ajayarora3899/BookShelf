package com.ajay.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReturnUser")
public class ReturnUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		String url="jdbc:mysql://localhost:3306/ComLibrary";
		String uname="root";
		String pass="Ajay@1997";
		
		int Empid=Integer.parseInt(req.getParameter("empid"));
		String Username=req.getParameter("uname");
		String Password=req.getParameter("pass");
		PrintWriter out=res.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);

			String Query3="Select Username,Password from Employee where EmpId='"+Empid+"'";
			PreparedStatement st3=con.prepareStatement(Query3);
			ResultSet rs3=st3.executeQuery(Query3);
			rs3.next();
			String uname3=rs3.getString("Username");
			String pass3=rs3.getString("Password");
			System.out.println(uname3);
			System.out.println(pass3);
			System.out.println(Username);
			System.out.println(Password);

			if(uname3.contentEquals(Username) && pass3.contentEquals(Password) )
			{
				HttpSession session=req.getSession();
				session.setAttribute("EmpId", Empid);
				res.sendRedirect("BookReturn.jsp");
			}
			else
				out.println("Invalid Username or Password");
		}catch(Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
	}	

}
