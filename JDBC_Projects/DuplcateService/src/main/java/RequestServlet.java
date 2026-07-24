import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    out.println("<html><body>");

	    String s = req.getMethod();

	    if (s.equals("POST"))
	        doPost(req, res);

	    if (s.equals("GET"))
	        doGet(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
			
			int x = s.executeUpdate("INSERT INTO emp101 VALUES ('" + name + "','" + pass + "')");
			ResultSet rs = s.executeQuery("select * from emp101");
			ResultSetMetaData rsmd = rs.getMetaData();
            
			out.println("<table bgcolor = 'yellow' border = 1 width = 200>");
			out.println("<tr>");
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				out.println("<th>"+ rsmd.getColumnName(i)+"</th>");
			}
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<tr>");
				
			}
					
		} catch(Exception e) {
			out.println("</table>");
			
			out.println("<h3><font color='red'>Database Error: " + e.getMessage() + "</font></h3>");
			
			if("codeSquadz".equals(name) && "codeSquadz".equals(pass))
				out.println("User is post valid");
			else {
				out.println("User is post invalid");
				
				out.println("</body></html>");
			}
			
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		if("codeSquadz".equals(name) && "codeSquadz".equals(pass))
			out.println("user is valid thorugh get");
		
		else {
			out.println("User is invalid thorugh get");
			out.println("</body></html>");
		}
	}
	
}