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
<%
if(session.getAttribute("EmpId")==null)
{
	response.sendRedirect("LoginUser.jsp");
}
%>
<div style='border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:250px; margin-left: 150px;margin-top:100px;'>
<div align='center'>
<h1>Return Here</h1>
</div>
<form action=FinalReturnModified>
&nbsp;&nbsp;Enter the Book ID : <input type=text name=BookId><br><br>
<input type=submit name=Return value=Return style='margin-left:250px ;width:100px; height:2000px ;font-size: 1500px; font-family: cursive;'>
</form>
</div>
<div align='center' style='border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:300px; margin-left: 150px;margin-top:25px;'>
<h1>Issued Books</h1>
<table cellpadding=10 cellborder=5>
<tr>
<th> ISSUE ID</th>
<th> BOOK ID</th>
<th> ISSUE DATE</th>
</tr>
<%
int empid=(Integer)session.getAttribute("EmpId");
String url="jdbc:mysql://localhost:3306/ComLibrary";
String uname="root";
String pass="Ajay@1997";
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,uname,pass);
	
	
	String Query1="Select * from Issued where EmpId='"+empid+"' and ReturnDate is NULL";
	PreparedStatement st=con.prepareStatement(Query1);
	ResultSet rs=st.executeQuery(Query1);
	while(rs.next())
	{
%>
<tr>
<td align="center"><%=rs.getInt("IssueId")%></td>
<td align="center"><%=rs.getInt("BookId")%></td>
<td align="center"><%=rs.getDate("IssueDate")%></td>
<%
	}
}catch(Exception e)
{
	System.out.println("Exception : "+e);
}
%>
</table>
</div>
</body>
</html>