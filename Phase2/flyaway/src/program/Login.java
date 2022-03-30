package program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/FlyAway";
	private static final String user = "root";
	private static final String password = "Mysqlpass@22";

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	static String usern;
	static String passw;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			usern = username;
			passw = password;

			if (GetUser() == true) {
				RequestDispatcher rd = request.getRequestDispatcher("searchflight.jsp");
				rd.forward(request, response);
			} else if (GetAdmin() == true) {
				RequestDispatcher rd = request.getRequestDispatcher("sessionhandling.jsp");
				rd.forward(request, response);
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("Invalid username. ");
				pw.println("Please try again. ");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean GetUser() {
		boolean connect = false;
		String query1 = "select * from user;";

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
				String UserName = rs.getString(1);
				String Password = rs.getString(2);

				if (UserName.equals(usern) && Password.equals(passw)) {
					connect = true;
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
		return connect;
	}

	public boolean GetAdmin() {
		boolean connect = false;
		String query1 = "select * from admin;";

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
				String adminName = rs.getString(1);
				String adminpass = rs.getString(2);

				if (adminName.equals(usern) && adminpass.equals(passw)) {
					connect = true;
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
		return connect;
	}

}
