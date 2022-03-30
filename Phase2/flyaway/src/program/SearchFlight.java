package program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.http.fileupload.RequestContext;

public class SearchFlight extends HttpServlet {

	static String dateT, sourceC, destinationC;
	static int numberP;

	private static final String url = "jdbc:mysql://localhost:3306/FlyAway";
	private static final String user = "root";
	private static final String password = "Mysqlpass@22";

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String DateOfTravel = request.getParameter("dateoftravel");
			String SourceCity = request.getParameter("sourcecity");
			String DestinationCity = request.getParameter("destinationcity");
			int NumberOfPersons = Integer.parseInt(request.getParameter("numberofpersons"));

			dateT = DateOfTravel;
			sourceC = SourceCity;
			destinationC = DestinationCity;
			numberP = NumberOfPersons;

			PrintWriter pw = response.getWriter();

			pw.print("<table border='2'>");
			pw.print("<tr>");
			pw.print("<th>Airline Name</th>");
			pw.print("<th>Price</th>");
			pw.print("<th>Source City</th>");
			pw.print("<th>Destination City</th>");
			pw.print("<th>Flight Depature Time</th>");
			pw.print("<th>Flight Arrival Time</th>");
			pw.print("<th>Flight Date</th>");
			pw.print("<th>class</th>");
			pw.print("<th>Flight Number</th>");
			pw.print("</tr>");

			for (int i = 0; i <= Search().size(); i++) {
				pw.print("<tr>");

				for (int r = 0; r < 9; r++) {
					if (r == 2) {
						continue;
					} else {
						pw.print("<td>" + ((java.util.List) Search().get(i)).get(r) + "</td>");
					}

				}
				pw.print("<td><a href='registerdetails.jsp?flightnumber=" + ((java.util.List) Search().get(i)).get(2)
						+ "'>" + ((java.util.List) Search().get(i)).get(2) + "</a><td>");
				pw.print("</tr>");
			}
			pw.print("</table>");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList Search() {
		String query1 = "select * from flightdetails;";

		ArrayList flight = new ArrayList();

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);

			stmt = con.createStatement();

			rs = stmt.executeQuery(query1);

			while (rs.next()) {
				String Dateoftravel = rs.getString(11);
				String SourceC = rs.getString(4);
				String DestinationC = rs.getString(5);
				int NumberPersons = rs.getInt(10);

				if (dateT.equals(Dateoftravel) && sourceC.equals(SourceC) && destinationC.equals(DestinationC)
						&& (numberP <= NumberPersons)) {

					ArrayList EachFlight = new ArrayList();

					EachFlight.add(rs.getString(1));
					EachFlight.add(rs.getInt(2));
					EachFlight.add(rs.getInt(3));
					EachFlight.add(rs.getString(4));
					EachFlight.add(rs.getString(5));
					EachFlight.add(rs.getString(6));
					EachFlight.add(rs.getString(7));
					EachFlight.add(rs.getString(11));
					EachFlight.add(rs.getString(12));

					flight.add(EachFlight);

				}
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

			try {
				con.close();
			} catch (SQLException se) {
			}
			try {
				stmt.close();
			} catch (SQLException se) {
			}
			try {
				rs.close();
			} catch (SQLException se) {
			}
		}
		return flight;
	}

}
