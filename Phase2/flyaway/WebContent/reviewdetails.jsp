<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,com.mysql.jdbc.Driver"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Review Passenger Details:</h1>
	<br>
	<br>

<% 
		final String url = "jdbc:mysql://localhost:3306/FlyAway";
		final String user = "root";
		final String password = "Mysqlpass@22";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		String query1 = "select * from registerdetails;";
		try{
				try{
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e)
						{
							e.printStackTrace();
						}
			con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			
			while (rs.next()) 
	    	 {  
				String name = rs.getString(1);
				String address = rs.getString(2);
				String age = rs.getString(3);
				String mobile = rs.getString(4);
				String email_id = rs.getString(5);
				String info = rs.getString(6);
				String country = rs.getString(7);    	 
%>
<table border="4" width="100%">
			<tr> 
				<th> Name</th>
				<th> Address</th>
				<th> Age</th>
				<th> Mobile</th>
				<th> Email_ID</th>
				<th> info</th>
				<th> Country</th>
				
			</tr>
			<tr> 
				<td> <%= name%> </td>
				<td> <%= address%> </td>
				<td> <%= age%> </td>
				<td> <%= mobile %> </td>
				<td> <%= email_id %> </td>
				<td> <%= info%> </td>
				<td> <%= country%> </td>
				
			</tr>
		</table>	
			
<% 
    	 }
		}
		 catch(SQLException sqlEx)
		 {
			sqlEx.printStackTrace(); 
		 } finally
		 	{
			
			 try{con.close();}catch(SQLException  se){}
			 try{stmt.close();} catch(SQLException  se){}
 		 	}
	%>

	<br><br>
	<button>
		<h3>
			<a href="payment.jsp">Go to Payment</a>
		</h3>
	</button>
</body>
</html>