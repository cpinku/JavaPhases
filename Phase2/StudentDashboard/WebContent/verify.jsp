<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String uname = request.getParameter("uname");
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
<title>Welcome to Register Page</title>
</head>
<body>
<h1>Welcome to Register Page</h1>
<%out.println("<h2>Welcome " + uname + "</h2>"); %>
Verify your details:
<form action="Dashboard.jsp" method="post">
	<table>
	<tr>
	<td>UserName:</td>
	<td><%out.println(uname); %><td>
	</tr>
	<tr>
	<td>Password:</td>
	<td><%out.println(pass); %><td>
	</tr>
	<tr>
	<td>Age:</td>
	<td><%out.println(age); %><td>
	</tr>
	<tr>
	<td>Branch</td>
	<td><%out.println(branch); %><td>
	</tr>
	<tr>
	<td>AadharNo:</td>
	<td><%out.println(adhno); %><td>
	</tr>
	</table>
	<input type="submit" value="FINAL SUMBIT">
</form>

</body>
</html>
