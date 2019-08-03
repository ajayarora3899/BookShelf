package com.ajay.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FinalReturnModified")
public class FinalReturnModified extends HttpServlet{

	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		int bookid=Integer.parseInt(req.getParameter("BookId"));
		
		PrintWriter out=res.getWriter();
		String url="jdbc:mysql://localhost:3306/ComLibrary";
		String uname="root";
		String pass="Ajay@1997";

			try
			{
				PreparedStatement st;
				ResultSet rs;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,pass);
				
				//Date returnDate=null;
				String query1="Select EmpId from Issued where BookId='"+bookid+"' "
						+ "and ReturnDate is NULL ";
				st=con.prepareStatement(query1);
				rs=st.executeQuery(query1);
				rs.next();
				int empid=rs.getInt("EmpId");
				System.out.println(empid);
				
				String query2="Update Issued set ReturnDate=current_date() "
						+ "where BookId='"+bookid+"' and ReturnDate is NULL";
				st=con.prepareStatement(query2);	
				st.execute(query2);
				
				
				String query3="Select Count from Employee where EmpId='"+empid+"' ";
				st=con.prepareStatement(query3);
				rs=st.executeQuery(query3);
				rs.next();
				int count=rs.getInt("Count");
				System.out.println(count);
				count--;
				
				String query4="Update Employee set Count='"+count+"' where EmpId='"+empid+"'";
				st=con.prepareStatement(query4);
				st.execute(query4);
				
				String query6="Select Copies from Book where BookId='"+bookid+"'";
				st=con.prepareStatement(query6);
				rs=st.executeQuery(query6);
				rs.next();
				int copies=rs.getInt("Copies");
				copies++;
				
				String query5="Update Book set Copies='"+copies+"' where BookId='"+bookid+"'";
				st=con.prepareStatement(query5);
				st.execute(query5);
				
				out.println("Successfully returned");
	
			}catch(Exception e)
			{
				System.out.println("Exception : "+e.getMessage());
			}
	}

}
