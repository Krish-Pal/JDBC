import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class DemoServlet1 implements Servlet
{
    public void init(ServletConfig con) {}
    
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("hello servlet ");
        out.println("<br>");
        out.println("Refrence Id="+this);
        out.println("<br>");
        out.println("Thread Name="+Thread.currentThread().getName());
        out.println("</body></html>");
    }
    
    public void destroy(){}
    
    public ServletConfig getServletConfig() { return null; }
    
    public String getServletInfo() { return null; }
}