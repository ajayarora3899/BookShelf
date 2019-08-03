package com.ajay.projects;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookIssuedModified")
public class BookIssuedModified extends HttpServlet {

	private static final long serialVersionUID = 1L;

		public void service(HttpServletRequest req,HttpServletResponse res) 
		{
			String url="jdbc:mysql://localhost:3306/ComLibrary";
			String uname="root";
			String pass="Ajay@1997";
			
			int empId=Integer.parseInt(req.getParameter("empid"));
			String username=req.getParameter("uname");
			String password=req.getParameter("pass");
			int bookid=Integer.parseInt(req.getParameter("BookId"));

				try
				{
					PrintWriter out=res.getWriter();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pass);	
						String Query1="Select Copies from Book where BookId='"+bookid+"'";
						PreparedStatement st=con.prepareStatement(Query1);
						ResultSet rs=st.executeQuery(Query1);
						rs.next();
						
						int copies=rs.getInt("Copies");
						
						if(copies!=0)
						{
							String Query3="Select Username,Password,Count from Employee where EmpId='"+empId+"'";
							PreparedStatement st3=con.prepareStatement(Query3);
							ResultSet rs3=st3.executeQuery(Query3);
							rs3.next();
							
							String uname3=rs3.getString("Username");
							String pass3=rs3.getString("Password");
							int count=rs3.getInt("Count");
							
							if(uname3.contentEquals(username) && pass3.contentEquals(password) && count<2)
							{
								copies--;
								count++;
								String Query2="Update Book set Copies='"+copies+"' where BookId='"+bookid+"'";
								PreparedStatement st2=con.prepareStatement(Query2);
								st2.execute(Query2);
								
								String Query4="Update Employee set Count='"+count+"' where EmpId='"+empId+"'";
								PreparedStatement st4=con.prepareStatement(Query4);
								st4.execute(Query4);
								
								String Query5="insert into Issued value (null,'"+empId+"','"+bookid+"',current_date(),null)";
								PreparedStatement st5=con.prepareStatement(Query5);
								st5.execute(Query5);
								
								out.println("Book Issued Successfully");
							}
							else
								out.println("Invalid username or password or issue limit may have exceeded");
						}
						else
							out.println("Book is currently Unavailable");
				}catch(Exception e)
				{
					System.out.println("Hello catch");
					System.out.println("Exception : "+e.getMessage());
				}
	}
}
