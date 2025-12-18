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
 * Servlet implementation class SearchEmployeeServlet
 */
@WebServlet("/SearchEmployee")
public class SearchEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management_system","root","Soma@2003");
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM employees where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            
            

            if (rs.next()) {
                out.println("<h3>Name: " + rs.getString("name") + "</h3>");
                out.println("<h3>Email: " + rs.getString("email") + "</h3>");
                out.println("<h3>Department: " + rs.getString("department") + "</h3>");
            } else {
                out.println("<h3>Employee Not Found</h3>");
            }
            out.println("<br><a href='index.html'>Home</a>");

        } catch (Exception e) {
            out.println(e);
        }
	}

	

}
