package Regi;

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
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
		int n= Integer.parseInt(request.getParameter("ID"));
		String p= request.getParameter("Pwd");
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","");
			PreparedStatement ps = con.prepareStatement("select * from rishubhchahar_111915104_details where emp_id='" + n + "");
			ResultSet rs = ps.executeQuery();
          
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>emp_id</th><th>Firstname</th><th>Lastname</th><th>DOB</th><th>Contact</th><tr>");  
            while (rs.next()) 
            {    
            	
             String id = rs.getString("emp_id");  
             String fn = rs.getString("Firstname");
             String ln = rs.getString("Lastname");
             String dob = rs.getString("DOB");
             String cn = rs.getString("Contact");
             out.println("<tr><td>" + id + "</td><td>" + fn + "</td><td>" + ln + "</td><td>" + dob + "</td><td>" + cn + "</td><tr>");   
            
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
	}

}
