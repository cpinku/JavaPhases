<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1> Change Password </h1>
	<hr>
	<br>
	<br>
	<form action="changepassword" method="post">
		Old Password <input type="text" name="oldpass"><br>
		<br> New Password <input type="text" name="newpass"><br>
		<br> Confirm New Password <input type="text" name="confpass"><br>
		<br> <input type="submit" value="Change Password"><br>
		<br>
	</form>
</body>
</html>