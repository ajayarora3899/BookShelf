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
<div style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:575px; margin-left: 50px; margin-top: 120px">
<div align="center">
<img src="open-book.jpg" width=200px height=200px style="margin-top: 50px; margin-bottom: 20px;">
</div>
<div align="center">
<b>--- Enter Book Details ---</b><br><br>
</div>

	<form action="AdminUpdate">
		&nbsp;&nbsp;Book Id : <input type="text" name="BookId" style="height:20px;width: 200px;"><br>
		&nbsp;&nbsp;Book Title : <input type="text" name="BookTitle" style="height:20px;width: 200px;"><br>
		&nbsp;&nbsp;Author : <input type="text" name="Author" style="height:20px;width: 200px;"><br>
		&nbsp;&nbsp;Edition : <input type="text" name="Edition" style="height:20px;width: 200px;"><br>
		&nbsp;&nbsp;Copies : <input type="text" name="Copies" style="width:200px ;height:20px"><br><br>
		<input type="submit" name="Update" value="Update" style="margin-left: 280px;width: 100px; font-size: 1500px;">
	</form>

</div>


</body>
</html>