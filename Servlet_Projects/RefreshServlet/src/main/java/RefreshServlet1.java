import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RefreshServlet1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        res.setHeader("Refresh", "4; URL=index.html");

        out.println("<h2>Welcome to Codequadz Web</h2>");
        out.println("<p>You will be redirected in 4 seconds...</p>");
    }
}