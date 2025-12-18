package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			int Emp_id =Integer.parseInt(request.getParameter("id"));
		
		
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management_system","root","Soma@2003");
				PreparedStatement psmt = conn.prepareStatement("delete from Employees where id=?");
				
				psmt.setInt(1,Emp_id);
;				
				psmt.executeUpdate();
				
				out.println("<h3>Employee Deleted</h3>");
	            out.println("<a href='viewEmployees'>View Employees</a>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            
		
	}



}
