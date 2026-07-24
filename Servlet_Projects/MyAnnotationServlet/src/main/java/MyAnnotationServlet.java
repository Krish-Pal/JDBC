import java.io.IOException;
import java.io.PrintWriter;

// Note: If you are using Tomcat 9 or older, change 'jakarta' to 'javax'
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyAnnotationServlet", urlPatterns = {"/hello"})
public class MyAnnotationServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello World Servlet Annotation Example</h2>");
        out.close();
    }
}