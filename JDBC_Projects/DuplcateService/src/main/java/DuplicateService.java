
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

public class DuplicateService extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
super.service(req,res);
res.setContentType("text/html");
   PrintWriter out = res.getWriter();
out.println("DuplicateService");
out.println("</body></html>");

}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
  res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
  out.println("<html><body>");
  out.println("Get Method");
    out.println("</body></html>");

}
}