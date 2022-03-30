package com;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DBConnection;
/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/Login")
public class Login extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
* @see HttpServlet#HttpServlet()
*/
 public Login() {
 super();
 // TODO Auto-generated constructor stub
 }
 /**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
response)
 */
 protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
 // TODO Auto-generated method stub

 try {
 PrintWriter out = response.getWriter();
 out.println("<html><body>");

 Properties props = new Properties();
 //props.load(in);
//connection information
DBConnection conn = new DBConnection("jdbc:mysql://localhost:3306//productdetails", "root", "Mysqlpass@22");
Statement stmt =conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
 stmt.executeUpdate("insert into product (id, name, price) values (4,'New Product', 17800.00 ");

 //query the table and get all information
 ResultSet rst = stmt.executeQuery("select * from product");

//find what the user typed into the search box
String productSearch = request.getParameter("search");
 //out.println(productSearch);
//user hasn't typed anything so display table
if(productSearch == null)
 {
 out.println("The following are the elements in the table" + "<Br>" + "<Br>");
 //simple while loop to print all elements in table
while (rst.next()) {
 out.println(rst.getInt("ID") + ": " + rst.getString("name") +" costs: $" +rst.getDouble("price") + "<Br>");
 }
 }
//user typed something
else
 {
 //select the row corresponding to the id number
String sql_res= "select * from product where id=" +productSearch;
 ResultSet inTable = stmt.executeQuery(sql_res);

//if not empty then print all product details
if(inTable.next())
	out.println(rst.getInt("ID") + ": " + rst.getString("name") +" costs: $" +rst.getDouble("price") + "<Br>");
 //empty so print error message
else
out.println("There was no element with product ID: "+ productSearch + " found in the table, please try again");

 }

 stmt.close();
out.println("</body></html>");
 conn.closeConnection();
 } catch (ClassNotFoundException e) {
	 e.printStackTrace();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse
	response) throws ServletException, IOException {
	 // TODO Auto-generated method stub
	 doGet(request, response);
	 }
	}