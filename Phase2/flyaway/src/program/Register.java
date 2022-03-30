package program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class Register extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/FlyAway";
	private static final String user = "root";
	private static final String password = "Mysqlpass@22";

	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement prSt;

	static String namePass;
	static String addressPass;
	static String agePass;
	static String mobilePass;
	static String emailPass;
	static String infoPass;
	static String countryPass;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String passname = request.getParameter("name");
			String passaddress = request.getParameter("address");
			String passage = request.getParameter("age");
			String passmobile = request.getParameter("mobile");
			String passemail = request.getParameter("email");
			String passinfo = request.getParameter("info");
			String passcountry = request.getParameter("country");

			namePass = passname;
			addressPass = passaddress;
			agePass = passage;
			mobilePass = passmobile;
			emailPass = passemail;
			infoPass = passinfo;
			countryPass = passcountry;

			RegisterPassenger();

			HttpSession session = request.getSession();
			session.setAttribute("namePass", namePass);

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body>");
			pw.println("<table width='100%' border='4' >");

			pw.println("<tr>");
			pw.println("<th> Name</th>");
			pw.println("<th> Address</th>");
			pw.println("<th> Age</th>");
			pw.println("<th> Mobile</th>");
			pw.println("<th> Email_ID</th>");
			pw.println("<th> info</th>");
			pw.println("<th> Country</th>");

			pw.println("</tr>");
			pw.println("<tr> ");
			pw.println("<td>" + namePass + "</td>");
			pw.println("<td>" + addressPass + "</td>");
			pw.println("<td>" + agePass + "</td>");
			pw.println("<td>" + mobilePass + "</td>");
			pw.println("<td>" + emailPass + "</td>");
			pw.println("<td>" + infoPass + "</td>");
			pw.println("<td>" + countryPass + "</td>");

			pw.println("</tr>");
			pw.println("</table>");
			pw.println("<br><br>");
			pw.println("<button>");
			pw.println("<h3> <a href='payment.jsp'>Go to Payment</a> </h3> ");
			pw.println("</button>");

			pw.println("</html></body>");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void RegisterPassenger() {
		String query1 = "INSERT INTO registerdetails  VALUES(?,?,?,?,?,?,?);";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			prSt = con.prepareStatement(query1);

			prSt.setString(1, namePass);
			prSt.setString(2, addressPass);
			prSt.setString(3, agePass);
			prSt.setString(4, mobilePass);
			prSt.setString(5, emailPass);
			prSt.setString(6, infoPass);
			prSt.setString(7, countryPass);

			prSt.execute();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				prSt.close();
			} catch (SQLException se) {
			}
			try {
				con.close();
			} catch (SQLException se) {
			}
			try {
				stmt.close();
			} catch (SQLException se) {
			}
		}
	}

}
