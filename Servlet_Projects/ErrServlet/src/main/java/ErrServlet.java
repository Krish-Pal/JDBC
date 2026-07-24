import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/err")
public class ErrServlet extends GenericServlet {

	public void service (ServletRequest req, ServletResponse res ) throws ServletException, IOException {
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("bavri pooch inavlid user");
		out.println("</body></html>");
		
	}
	
}
