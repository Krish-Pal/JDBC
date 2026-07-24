package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yt_demo",
                    "root",
                    "root"
            );

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM register WHERE email=? AND password=?"
            );

            ps.setString(1, myemail);
            ps.setString(2, mypass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // ✅ Success

                HttpSession session = req.getSession();
                session.setAttribute("session_name", rs.getString("name"));

                RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
                rd.forward(req, resp);

            } else {
                // ❌ Error message (correct way)

                req.setAttribute("errorMsg", "Email id and password didn't match");

                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.forward(req, resp);
            }

            // ✅ Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

            out.println("<h3 style='color:red; text-align:center;'>" + e.getMessage() + "</h3>");

            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }
    }
}