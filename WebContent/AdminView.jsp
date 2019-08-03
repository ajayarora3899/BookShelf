<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin View !!!</title>
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
<div align='center' style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:600px; height:800px; margin-left: 50px; margin-top: 25px">
<h1>Record</h1>
<table cellpadding=5 cellborder=5>
<tr>
<th> Book ID</th>
<th> Book Title</th>
<th> Author</th>
<th> Edition</th>
<th> Copies</th>
</tr>
<%
String url="jdbc:mysql://localhost:3306/ComLibrary";
String uname="root";
String pass="Ajay@1997";	  		
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url,uname,pass);
String query = "SELECT * from Book" ;
PreparedStatement st=con.prepareStatement(query);
ResultSet rs=st.executeQuery(query);
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
%>
</table>
</div>
</body>
</html>