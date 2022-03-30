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
	<h1>Welcome to Search Flight Page</h1>
	<hr>
	<br>
	<br>
	<h3>Please enter your flight details</h3>
	<br>
	<form action="searchflight" method="post">
		Date of Travel(YYYY-MM-DD)<input type="text" name="dateoftravel"><br>
		<br> Source City <input type="text" name="sourcecity"><br>
		<br> Destination City <input type="text" name="destinationcity"><br>
		<br> Number of Persons <input type="text" name="numberofpersons"><br>
		<br> <input type="submit" value="Search">
	</form>


</body>
</html>