import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContextAttribute extends HttpServlet {
	
	
	
	PrintWriter out;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		out = res.getWriter();
		
		ServletContext ctx = getServletContext();

		Integer count = (Integer) ctx.getAttribute("count");

		if (count == null) {
		    count = 0;
		}

		count++;

		ctx.setAttribute("count", count);

		out.println(count);
		
	}
}
