<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here !!!</title>
<style>
body{
background-image: url("photo-1524995997946-a1c2e315a42f.jpeg");
background-position: center;
background-size: cover;
background-repeat: no-repeat;

}
</style>
</head>

<body>
<div style='border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:325px; margin-left: 150px;margin-top:25px;'>
<div align='center'>
<h1>Issue Here</h1>
</div>
<form action=BookIssuedModified>
&nbsp;&nbsp;Enter the Book ID : <input type=text name=BookId><br>
&nbsp;&nbsp;Employee Id : <input type=text name=empid><br>
&nbsp;&nbsp;Username : <input type=text name=uname><br>
&nbsp;&nbsp;Password : <input type=password name=pass><br><br>
<input type=submit name=Issue value=Issue style='margin-left:250px ;width:100px; height:2000px ;font-size: 1500px; font-family: cursive;'>
</form>
</div><br><br>
<div align='center' style='border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:600px; height:400px; margin-left:50px;'>
<div align='center'>
<h1>BOOK DETAILS</h1>
</div>
<table cellpadding=10 cellborder=5>
<tr>
<th> Book Id</th>
<th> Book Title</th>
<th> Author</th>
<th> Edition</th>
<th> Copies</th>
</tr>
<%
String url="jdbc:mysql://localhost:3306/ComLibrary";
String uname="root";
String pass="Ajay@1997";

String booktitle=request.getParameter("BookTitle");
String author=request.getParameter("Author");

if(booktitle==null && author==null)
{
	response.sendRedirect("Issue.jsp");
}

if(booktitle!=null && booktitle.length()==0 && author!=null && author.length()==0)
{
	response.sendRedirect("Issue.jsp");
}

if(booktitle !=null && booktitle.length()>0)
{
	booktitle="%"+booktitle+"%";
}
else 
	booktitle="%XXX%";

if(author !=null && author.length()>0)
{
	author="%"+author+"%";
}
else 
	author="%XXX%";

String query=
"select * from Book where BookTitle like '"+booktitle+"' OR"
+" Author like '"+author+"' ";
try
{
	String driver="com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	
	Connection con=DriverManager.getConnection(url,uname,pass);
	PreparedStatement st=con.prepareStatement(query);
	ResultSet rs = st.executeQuery(query);
	while(rs.next())
	{
%>
<tr>
<td align="center"><%=rs.getInt("BookID")%></td>
<td align="center"><%=rs.getString("BookTitle")%></td>
<td align="center"><%=rs.getString("Author")%></td>
<td align="center"><%=rs.getString("Edition")%></td>
<td align="center"><%=rs.getInt("Copies")%></td>
</tr>
<%
	}
}catch(Exception e)
{
	System.out.println("Exception :"+e);
}
%>
</table>
</div>
</body>
</html>