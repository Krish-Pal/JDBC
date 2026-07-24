import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // TODO: Database details apne hisaab se update kar lena
    String dbUrl = "jdbc:mysql://localhost:3306/your_database_name";
    String dbUser = "root";
    String dbPassword = "your_password";

    // doGet: Form dikhane ke liye use hota hai
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML aur thodi basic CSS form ko theek dikhane ke liye
        out.println("<html><head><title>Add Student</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; padding: 20px; background-color: #f4f4f4;}");
        out.println(".container { max-width: 400px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 0px 10px #aaa; }");
        out.println("input { width: 100%; margin-bottom: 15px; padding: 10px; box-sizing: border-box; }");
        out.println("button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer;}");
        out.println("button:hover { background-color: #218838; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2>Add New Student</h2>");
        out.println("<form action='addStudent' method='POST'>");
        out.println("<label>Student Name:</label>");
        out.println("<input type='text' name='name' required>");
        out.println("<label>Email Address:</label>");
        out.println("<input type='email' name='email' required>");
        out.println("<label>Course:</label>");
        out.println("<input type='text' name='course' required>");
        out.println("<button type='submit'>Save Student</button>");
        out.println("</form>");
        out.println("</div>");

        out.println("</body></html>");
    }

    // doPost: Form submit hone ke baad database me save karne ke liye
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // MySQL Driver load kar rahe hain (make sure mysql-connector-java.jar build path me ho)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database se connection
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            // Insert query
            String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, course);

            int result = pstmt.executeUpdate();

            // Result display karna
            out.println("<html><body><div style='text-align:center; margin-top:50px; font-family:Arial;'>");
            if (result > 0) {
                out.println("<h3 style='color:green;'>Student added successfully!</h3>");
            } else {
                out.println("<h3 style='color:red;'>Failed to add student.</h3>");
            }
            out.println("<a href='addStudent'>Add Another Student</a>");
            out.println("</div></body></html>");

            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            out.println("<h3>Error: JDBC Driver not found! Ensure the MySQL Connector jar is added.</h3>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<h3>Database connection error! Check credentials.</h3>");
            out.println("<p>" + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
}