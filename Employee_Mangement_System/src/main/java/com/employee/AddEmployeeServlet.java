package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the parameters from the index.html 		
		String Emp_name=request.getParameter("name");
		String Email_name=request.getParameter("email");
		String Dept_name=request.getParameter("department");
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		//establishing the jdbc connection 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management_system","root","Soma@2003");
			PreparedStatement psmt=conn.prepareStatement(" INSERT INTO Employees (name, email, department) VALUES (?, ?, ?)");
			
			psmt.setString(1,Emp_name);
			psmt.setString(2,Email_name);
			psmt.setString(3, Dept_name);
			
			psmt.executeUpdate();
			out.println("<h3>Sucessfully added Employee details</h3>");
			
			out.println("<a href='index.html'>Home</a>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 out.println("<h3 style='color:red'>Error occurred</h3>");
	            out.println("<pre>" + e.getMessage() + "</pre>");
		}
		
		}

}




