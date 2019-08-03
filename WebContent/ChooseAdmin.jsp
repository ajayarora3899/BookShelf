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
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("LoginAdmin.jsp");
	}
%>
<div style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:650px; margin-left: 50px; margin-top: 80px">

<form action="Logout">	
		<br><input type="submit" name="Logout" value="Logout" style="margin-left: 300px; width: 80px; height:1500px; font-size: 100px">
</form>
	
<img src="open-book.jpg" width=200px height=200px style="margin-left:100px; margin-top: 50px; margin-bottom: 20px;">
	
	
	<form action="ChooseAdmin">	
	<br><b>&nbsp;&nbsp;Choose any action of your choice</b><br><br>
		<input type="radio" name="radio" value="Add" style="margin-left: 10px;">Add<br>
		<input type="radio" name="radio" value="Remove" style="margin-left: 10px;">Remove<br>
		<input type="radio" name="radio" value="Update" style="margin-left: 10px;">Update<br>
		<input type="radio" name="radio" value="ViewAll" style="margin-left: 10px;">ViewAll<br><br>
		<input type="submit" name="Submit" value="Submit" style="margin-left: 300px; width: 80px; height:1500px; font-size: 100px">
	</form>
	
	
</div>
</body>
</html>