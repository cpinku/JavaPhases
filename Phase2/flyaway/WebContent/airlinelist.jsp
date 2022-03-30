<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page import="javax.websocket.Session"%>
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

<h2>List of Airline:</h2>
<h2>Airline Name:</h2>

	<% 
		final String url = "jdbc:mysql://localhost:3306/FlyAway";
		final String user = "root";
		final String password = "Mysqlpass@22S";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		String query1 = "select * from flightdetails ";
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
					 
%>


	
	<table border="4" width="50%">
			
			<tr> 
				<td><%=airlinename %> </td>
				
				
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
</body>
</html>