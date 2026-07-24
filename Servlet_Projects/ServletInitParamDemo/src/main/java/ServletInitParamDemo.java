import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/initparam"},
    initParams = {
        @WebInitParam(name = "email", value = "abc@gmail.com"),
        @WebInitParam(name = "phone", value = "123455")
    }
)
public class ServletInitParamDemo extends HttpServlet {

    private String email = "", phone = "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        email = config.getInitParameter("email");
        phone = config.getInitParameter("phone");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String html = "<h2>Access data using Servlet Init Parameters</h2>";
        html += "<h3>Email : " + email + "<br/>Phone No. : " + phone + "</h3>";

        out.println(html);
    }
}