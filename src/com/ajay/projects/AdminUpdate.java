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

@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		String url="jdbc:mysql://localhost:3306/ComLibrary";
		String uname="root";
		String pass="Ajay@1997";
		PrintWriter out=res.getWriter();
		
		
		
		try{
				int bookid=Integer.parseInt(req.getParameter("BookId"));
				String booktitle=req.getParameter("BookTitle");
				String author=req.getParameter("Author");
				String edition=req.getParameter("Edition");
				if(bookid!=0 && booktitle.length()!=0 && author.length()!=0 && edition.length()!=0)
				{		
					String driver="com.mysql.cj.jdbc.Driver";
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url,uname,pass);
					
					String query1="Select BookId from Book where BookId='"+bookid+"'";
					PreparedStatement st1=con.prepareStatement(query1);
					ResultSet rs=st1.executeQuery(query1);
					if(rs.next())
					{
						String query=
					"update Book set BookTitle=?,Author=?,Edition=? where BookId=?";
						PreparedStatement st=con.prepareStatement(query);
						st.setInt(4, bookid);
						st.setString(1, booktitle);
						st.setString(2, author);
						st.setString(3, edition);
						boolean flag=st.execute();
						
						if(flag==false){
							out.println("Successfully Updated....");
						}else{
						
							out.println("Sorry");
						}
						st.close();
						con.close();
					}
					else
					{
						out.println("Book doesn't exists");
					}
				}else
				{
					out.println("Enter all columns");
				}
		}catch (SQLException e) {
			System.out.println("Exception : "+e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Exception : "+e.getMessage());
		}catch (NumberFormatException e) {
			out.println("Book id cant be null");
		}
	}
}
