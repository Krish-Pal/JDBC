import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OracleServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<html><body>");

        ServletContext ctx = getServletContext();

        String driver = ctx.getInitParameter("driver");
        String url = ctx.getInitParameter("url");
        String user = ctx.getInitParameter("user");
        String pass = ctx.getInitParameter("pass");

        try {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp101");

            while (rs.next()) {
                out.println(rs.getString(1) + " ");
                out.println(rs.getString(2) + "<br>");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error:</h3>");
            out.println(e.getMessage());
        }

        out.println("</body></html>");
    }
}