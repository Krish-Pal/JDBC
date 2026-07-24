import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/vnd.ms-excel");

        PrintWriter out = res.getWriter();

        out.println("Name\tHindi\tEnglish\tMaths\tTotal");
        out.println("Lalu\t35\t95\t80\t=SUM(B2:D2)");
    }
}