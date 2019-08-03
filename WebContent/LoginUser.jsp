<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login User !!!</title>
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
<script type="text/javascript">
window.history.forward(1);
</script>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
%>
<div style="border:10px; border-style:solid; border-color:black; border-radius:30px; font-size:25px ; background-color:Bisque; width:400px; height:700px; margin-left: 50px; margin-top: 50px">
<div align="center">
<img src="open-book.jpg" width=200px height=200px style="margin-top: 50px; margin-bottom: 20px">
<h1 style="color:black;text-align: center;font-family:fantasy;font-size: 45px; font-style: italic;">Crescent Moon Library</h1>
</div>	
	<form action="LoginUser">
	&nbsp;&nbsp;&nbsp;&nbsp;<b>-------- Choose your action --------</b><br><br>
	&nbsp;&nbsp;<input type="radio" name="radio" value="ISSUE"> ISSUE<br><br>
	&nbsp;&nbsp;<input type="radio" name="radio" value="RETURN"> RETURN<br>
	<input type="submit" style="margin-left:250px ;width:100px; height:2000px ;font-size: 1500px; font-family: cursive;">
	</form>
</div>
</body>
</html>