<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("LoginUser.jsp");
	}
%>
<div style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:500px; margin-left: 50px; margin-top: 160px">
	<form action="LogoutUser">
		<br><input type="submit" name="Logout" value="Logout" style="margin-left:250px ;width:100px; height:2000px ;font-size: 1500px; font-family: cursive;">
	</form>
<div align="center">
<img src="open-book.jpg" width=200px height=200px style="margin-top: 25px; margin-bottom: 25px">
<br><b>--- Enter Details ---</b><br>
</div>
	<form action=ReturnUser>
		&nbsp;&nbsp;Employee Id : <input type=text name=empid><br>
		&nbsp;&nbsp;Username : <input type=text name=uname><br>
		&nbsp;&nbsp;Password : <input type=password name=pass><br><br>
		<input type=submit name=Return value=Return style="margin-left:250px ;width:100px; height:2000px ;font-size: 1500px; font-family: cursive;">
	</form>
</div>
</body>
</html>