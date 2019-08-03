package com.ajay.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminAdd")
public class AdminAdd extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		String url="jdbc:mysql://localhost:3306/ComLibrary";
		String uname="root";
		String pass="Ajay@1997";
		PrintWriter pw=res.getWriter();
			
		try {
			
			String driver="com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url,uname,pass);
			
			PrintWriter out=res.getWriter();
			int bookid=Integer.parseInt(req.getParameter("BookId"));
			String booktitle=req.getParameter("BookTitle");
			String author=req.getParameter("Author");
			String edition=req.getParameter("Edition");
			int copies=Integer.parseInt(req.getParameter("Copies"));
						
			if(bookid!=0 && booktitle.length()!=0 && author.length()!=0 && edition.length()!=0 && copies!=0)
			{
				String query1="Select BookId from Book where BookId='"+bookid+"'";
				PreparedStatement st1=con.prepareStatement(query1);
				ResultSet rs=st1.executeQuery(query1);
				if(rs.next())
				{
					out.print("Already Existing Book");
				}
				else
				{
					String query="insert into Book (BookId,BookTitle,Author,Edition,Copies) values(?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(query);
					st.setInt(1, bookid);
					st.setString(2, booktitle);
					st.setString(3, author);
					st.setString(4, edition);
					st.setInt(5, copies);
					st.execute();
					out.println("Successfully Added....");
					st.close();
				}
			}
			else
				out.println("Please Add all the columns");
			con.close();
		}catch (SQLException e) {
			System.out.println("Exception : "+e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Exception : "+e.getMessage());
		}catch (NumberFormatException e) {
			pw.println("BookId cant be empty because it is a primary key");
		}
	
	}
}
