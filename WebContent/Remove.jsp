<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("LoginAdmin.jsp");
	}
%>
<div style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:400px; margin-left: 50px; margin-top:255px;">
<img src="open-book.jpg" width=200px height=200px style="margin-left: 100px;margin-top: 50px;">
	<form action="AdminRemove">
	<div align="center">
	<br><b>--- Enter Book Id ---</b><br>
	</div>
		&nbsp;&nbsp;Book Id : <input type="text" name="BookId"><br>
		<input type="submit" name="Remove" value="Remove" style="margin-left: 280px;width: 100px; font-size: 1500px;">
	</form>
</div>

</body>
</html>