package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEmployeesServlet
 */
@WebServlet("/viewEmployees")
public class ViewEmployeesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("<table>");
		out.println("List of Employees");
		//out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Action</th></tr>");
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management_system","root","Soma@2003");
        PreparedStatement st = conn.prepareStatement("select*from Employees");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            //out.println("<tr>");
            /*out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("name") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("department") + "</td>");
            out.println("<td><a href='DeleteEmployee?id=" + rs.getInt("id") + "'>Delete</a></td>");
            out.println("</tr>");*/
            out.println("<br>");
            out.println("<hr>");
            
            out.println( rs.getInt("id") );
            out.println("<br>");
            out.println( rs.getString("name") );
            out.println("<br>");
            out.println( rs.getString("email"));
            out.println("<br>");
            out.println(rs.getString("department"));
            out.println("<br>");
            out.println("<a href='DeleteEmployee?id=" + rs.getInt("id") + "'>Delete</a>");
            //out.println("</tr>");
        }

        out.println("</table>");
        out.println("<br><a href='index.html'>Home</a>");

    } catch (Exception e) {
        out.println(e);
    }
}

	}


