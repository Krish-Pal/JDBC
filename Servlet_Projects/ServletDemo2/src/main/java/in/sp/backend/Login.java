package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String myemail = req.getParameter("email1");
		String mypass  = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();

		// ✅ FIX: safe equals (null error khatam)
		if("krishpalproco@gmail.com".equals(myemail) && "Krish123".equals(mypass)) {
			
			HttpSession session = req.getSession();
			session.setAttribute("name_key","Krish Pal");
			
			RequestDispatcher rd =  req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);

		} else {
			
			resp.setContentType("text/html");
			out.print(" <h3 style = 'color:red'> Email id and password did't matched!!! <h3/> <br/>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		} 
	}
}