import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class SendRedirect extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("before");

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/FREEPDB1", "system", "ROOT@123");

			Statement s = c.createStatement();

			String s1 = "select * from emp101 where name='" + name + "' and pass='" + pass + "'";

			ResultSet rs = s.executeQuery(s1);

			if (rs.next())
				// res.sendRedirect("well.html");
				 res.sendRedirect("wel");
				// res.sendRedirect("http://localhost:9090/tom16/wel");
				// res.sendRedirect("http://13.201.161.138:9090/tom30/wel");
			else
				res.sendRedirect("err");

		} catch (Exception e) {
			out.println(e);
		}

		out.println("after");
		out.println("</body></html>");
	}
}

// res.sendRedirect("http://localhost:9091/tom22/wel");
// res.sendRedirect("http://google.com");