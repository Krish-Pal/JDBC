import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {

	PrintWriter out;
	static int count = 0;
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		out = res.getWriter();
		
		destroy();
		out.println("<html><body>");
		
		out.println("<br>");
		out.println("hello servlet from generic servlet "+count);
		out.println("<br>");
		out.println("this");
		try {
			Thread.sleep(2000);
			
		} catch(Exception e) {
			
		}
		out.println(Thread.currentThread().getName());
		
		out.println("<body></html>");
	}
	public void destroy() {
		out.println("destroy");
		count++;
	}
	
}
