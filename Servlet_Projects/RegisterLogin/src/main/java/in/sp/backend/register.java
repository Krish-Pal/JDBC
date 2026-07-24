package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class register extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/yt_demo";
    private static final String USER = "root";
    private static final String PASS = "root"; 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");
        String mygender = req.getParameter("gender1");
        String mycity = req.getParameter("city1");

        // Validation
        if (myname == null || myemail == null || mypass == null ||
            mygender == null || mycity == null ||
            myname.isEmpty() || myemail.isEmpty() || mypass.isEmpty() || mycity.isEmpty()) {

            out.print("<h3 style='color:red'>All fields are required!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO register(name,email,password,gender,city) VALUES (?,?,?,?,?)")) {

                ps.setString(1, myname);
                ps.setString(2, myemail);
                ps.setString(3, mypass);
                ps.setString(4, mygender);
                ps.setString(5, mycity);

                int count = ps.executeUpdate();

                if (count > 0) {
                    out.print("<h3 style='color:green'>User registered successfully</h3>");
                } else {
                    out.print("<h3 style='color:red'>Registration failed</h3>");
                }

                RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
                rd.include(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();

            out.print("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");

            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            rd.include(req, resp);
        }
    }
}