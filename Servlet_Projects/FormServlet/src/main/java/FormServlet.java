import java.io.IOException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        ServletOutputStream out = res.getOutputStream();

        out.println("<html><head><title>Basic Form Processor Output</title></head>");
        out.println("<body>");
        out.println("<h1>Here is your Form</h1>");

        String title = req.getParameter("title");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String tel = req.getParameter("tel");
        String age = req.getParameter("age");
        String[] interest = req.getParameterValues("interests");

        out.println("<br>Your title is " + title);
        out.println("<br>Your name is " + name);
        out.println("<br>Your city is " + city);
        out.println("<br>Your country is " + country);
        out.println("<br>Your tel is " + tel);

        out.println("<br>Your interests include <ul>");

        if (interest != null) {
            for (String s : interest) {
                out.println("<li>" + s + "</li>");
            }
        } else {
            out.println("<li>No interests selected</li>");
        }

        out.println("</ul>");
        out.println("<br>Your age is " + age);
        out.println("</body></html>");
    }
}