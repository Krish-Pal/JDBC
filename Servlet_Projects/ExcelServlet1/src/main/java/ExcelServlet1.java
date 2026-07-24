import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelServlet1 extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            c = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:free",
                    "system",
                    "ROOT@123");

            stmt = c.createStatement();

            rs = stmt.executeQuery("SELECT * FROM emp101");

            ResultSetMetaData rd = rs.getMetaData();

            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Content-Disposition",
                    "attachment; filename=Employee.xls");

            PrintWriter out = res.getWriter();

            int count = rd.getColumnCount();

            // Column Names
            for (int i = 1; i <= count; i++) {
                out.print(rd.getColumnName(i));

                if (i != count)
                    out.print("\t");
            }

            out.println();

            // Data
            while (rs.next()) {

                for (int i = 1; i <= count; i++) {

                    out.print(rs.getString(i));

                    if (i != count)
                        out.print("\t");
                }

                out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
            }

            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
            }

            try {
                if (c != null)
                    c.close();
            } catch (Exception e) {
            }
        }
    }
}