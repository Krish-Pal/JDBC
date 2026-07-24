import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 


public class AllServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		
		Enumeration<String> e = req.getParameterNames();
		

		while(e.hasMoreElements()) { 
			String name = e.nextElement(); 
			String value = req.getParameter(name);
			
			out.println(name + " = " + value);
			out.println("<br>");
		}
		out.println("</body></html>"); 
	}
}