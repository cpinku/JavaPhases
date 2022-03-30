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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

public class ChangePassword extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/FlyAway";
	private static final String user = "root";
	private static final String password = "Mysqlpass@22";

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static java.sql.PreparedStatement prSt;

	static String adminuser = Login.usern;
	static String oldpass = Login.passw;
	static String updatedpass;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String oldpassword = request.getParameter("oldpass");
			String newpassword = request.getParameter("newpass");
			String conpassword = request.getParameter("confpass");
			updatedpass = newpassword;

			if (oldpass.equals(oldpassword)) {
				if (newpassword.equals(conpassword)) {
					UpdatePassword();
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("notmatchingpassword.jsp");
					rd.forward(request, response);
				}
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("<a href='login.jsp' >Wrong Old Password</a>");
				// RequestDispatcher rd =
				// request.getRequestDispatcher("wrongoldpassword.jsp");
				// rd.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void UpdatePassword() {
		String sqlUpdate = "UPDATE admin SET password =? WHERE username=?";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			prSt = con.prepareStatement(sqlUpdate);

			System.out.println();

			prSt.setString(1, updatedpass);
			prSt.setString(2, Login.usern);

			int rowAffected = prSt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}