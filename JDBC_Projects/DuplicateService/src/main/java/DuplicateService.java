import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DuplicateService extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body>");
		out.println("Duplicate service");
		out.println("</body><html>");
		
		
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
