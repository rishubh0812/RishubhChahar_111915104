package Regi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
			int n = Integer.parseInt(request.getParameter("ID"));
			String p = request.getParameter("Pwd");
			
			PreparedStatement ps = con.prepareStatement("select * from rishubhchahar_111915104_details where emp_id='" + n + "'and Contact='"+ p +"'");
		//	ps.setString(1, n);
		//	ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				PreparedStatement ps1 = con.prepareStatement("select * from rishubhchahar_111915104_salary where emp_id=" + n);
				ResultSet rs1 = ps1.executeQuery();
				out.println("<table border=1 width=50% height=50%>");  
	            out.println("<tr><th>emp_id</th><th>Jobrole</th><th>Salary</th><th>Bonus</th><tr>");  
	            while (rs1.next()) 
	            {    
	            	
	             String id = rs1.getString("emp_id");  
	             String jr = rs1.getString("Jobrole");
	             String sa = rs1.getString("Salary");
	             String bo = rs1.getString("Bonus");
	             out.println("<tr><td>" + id + "</td><td>" + jr + "</td><td>" + sa + "</td><td>" + bo + "</td><tr>");   
	            
	            }  
	            out.println("</table>");  
	            out.println("</html></body>");  
	            con.close();  
			}
			
			else
			{
				out.println("Login Failed");
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
