<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String uname = (String)request.getSession().getAttribute("uname");
String pass = request.getParameter("pass");
String age = request.getParameter("age");
String branch = request.getParameter("branch");
String adhno = request.getParameter("adhno");
session.putValue("uname",uname);
session.putValue("pass",pass);
session.putValue("age",age);
session.putValue("branch",branch);
session.putValue("adhno",adhno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<body>
<h1>Welcome to Login Page</h1>
<%out.println("<h2>WELCOME" + uname + "</h2>"); %>
Fill the below details:
<form action="final.jsp" method="post">
	<table>
		<tr>
		<td>10th Marks %</td>
		<td><input type="text" name="marks10" value="" /></td>
		</tr>
		<tr>
		<td>12th Marks %</td>
		<td><input type="text" name="marks12" value="" /></td>
		</tr>
		<tr>
		<td>School Name</td>
		<td><input type="text" name="school" value="" /></td>
		</tr>
		<tr>
		<td>Math marks /100</td>
		<td><input type="text" name="mathm" value="" /></td>
		</tr>
		<tr>
		<td>Chemistry marks /100</td>
		<td><input type="text" name="chemm" value="" /></td>
		</tr>
		<tr>
		<td>Physics marks /100</td>
		<td><input type="text" name="phym" value="" /></td>
		</tr>
	</table>
	<input type="submit" value="SUBMITs">
</form>

</body>
</html>