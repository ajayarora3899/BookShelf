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


@WebServlet("/AdminRemove")
public class AdminRemove extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try {
		String url="jdbc:mysql://localhost:3306/ComLibrary";
		String uname="root";
		String pass="Ajay@1997";
		
		PrintWriter out=res.getWriter();
		int bookid=Integer.parseInt(req.getParameter("BookId"));
		
		String driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url,uname,pass);
		String query1="Select BookId from Book where BookId='"+bookid+"'";
		PreparedStatement st1=con.prepareStatement(query1);
		ResultSet rs=st1.executeQuery(query1);
		
		
		
		if(rs.next())
		{
				String query="delete from Book where BookId=?";
				PreparedStatement st=con.prepareStatement(query);
				st.setInt(1, bookid);
				boolean flag=st.execute();
				
				if(flag==false){
					out=res.getWriter();
					out.println("Successfully Deleted....");
				}else{
					out=res.getWriter();
					out.println("Sorry");
				}
				
				st.close();
				
		}
		else
		{
				out.print("BOOK DOES NOT EXIST");

		}
		con.close();
		}catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
			
	}
}
