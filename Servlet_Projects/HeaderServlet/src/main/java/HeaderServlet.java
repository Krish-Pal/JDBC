import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {
	
	PrintWriter out;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		out = res.getWriter();
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();
			String value = req.getHeader(name);
			out.println(name+" : "+ value);
			out.println("<br>");
		}
		out.println("Protocol "+req.getProtocol());
		out.println("<br");
		out.println("<method "+req.getMethod());
		out.println("br");
		out.println("Content Type" +req.getContentType());
		out.println("<br>");
		out.println("Content Length "+req.getContentLength());
	}
	
}
