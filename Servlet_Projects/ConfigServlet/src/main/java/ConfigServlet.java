import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Seedha parameter get kar liya
		String image = getInitParameter("image");
		String driver = getInitParameter("driver");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		// HTML tag typo fixed aur thoda formatting better kar diya
		out.println("<html>");
		out.println("<body background='" + image + "'>");
		out.println("<h2>Loaded Driver: " + driver + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}