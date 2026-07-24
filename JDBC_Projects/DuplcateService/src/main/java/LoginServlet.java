import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection(
				    "jdbc:oracle:thin:@localhost:1521/FREE",
				    "system",
				    "ROOT@123"
				);
			
			Statement s = c.createStatement();
			String s1 = "select * from emp101 where name ='"+"Krish"+"' and pass = '"+"CODE"+"'";
			
			ResultSet rs = s.executeQuery(s1);
			
			if(rs.next()) {
				out.println("<h3>User is valid</h3>");
			} else {
				out.println("<h3 style='color:red;'>User is Invalid</h3>");
			}

		} catch(Exception e) {
			// Ye line aapko batayegi agar database connect hone me koi error aaya
			out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
		} finally {
			// Finally block ensure karega ki tags humesha close hon
			out.println("</body></html>");
		}
	}
} 