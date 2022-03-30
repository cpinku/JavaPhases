<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
 <%@ page import="java.io.*,java.util.*,java.sql.*,com.mysql.jdbc.Driver" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<% 
		final String url = "jdbc:mysql://localhost:3306/FlyAway";
		final String user = "root";
		final String password = "Mysqlpass@22";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String ff = request.getParameter("flightnumber");
		
		String query1 = "select * from flightdetails where flight_no =" +ff ;
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
				String airlinename = rs.getString(1);
				int price = rs.getInt(2);
				String sourcecity = rs.getString(4);
				String destinationcity = rs.getString(6);
				String departuretime = rs.getString(6);
				String arrivaltime = rs.getString(7);
				String flightC = rs.getString(12);    	 
%>
<h2>Flight Details:</h2>
	
	<table border="4" width="100%">
			<tr> 
				<th>Airline Name</th>
				<th> Price</th>
				<th> Source City</th>
				<th> Destination City</th>
				<th> Departure Time</th>
				<th> Arrival Time</th>
				<th> Class</th>
				
			</tr>
			<tr> 
				<td><%=airlinename %> </td>
				<td> <%=price %></td>
				<td> <%=sourcecity %> </td>
				<td> <%=destinationcity %> </td>
				<td> <%=departuretime %> </td>
				<td> <%=arrivaltime  %> </td>
				<td> <%=flightC %></td>
				
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

		
	<h2> Enter Passenger's Personal Information:</h2>
	
	<form action="register" method="post">
	Full Name: <input type="text" name="name"> <br><br>
	Address: <input type="text" name="address"> <br><br>
	Age: <input type="text" name="age"> <br><br>
	Mobile: <input type="text" name="mobile"> <br><br>
	Email ID/ Username: <input type="text" name="email"> <br><br>
		Select one:
		<select>
			<option> SSN</option>
			<option>Addhar Card</option>
			<option>Passport</option>
			<option> Voter ID</option>
			<option> Driving license</option>
		</select>
	<input type="text" name="info">
	<br><br> Country<input type="text" name="country"> <br><br>
	<input type="submit" value="Register">
	</form>

</body>
</html>