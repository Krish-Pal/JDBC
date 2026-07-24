package Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcWithXml {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "mca6");

            stmt = conn.createStatement();

            createXMLTable(stmt);

            // Open XML file
            File f = new File("XML_DATA.xml");
            long fileLength = f.length();
            FileInputStream fis = new FileInputStream(f);

            String SQL = "INSERT INTO XML_DATA VALUES (?, ?)";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, 200);
            pstmt.setAsciiStream(2, fis, (int) fileLength);

            pstmt.executeUpdate();

            fis.close();

            SQL = "SELECT DATA FROM XML_DATA WHERE ID = 200";

            rs = stmt.executeQuery(SQL);

            if (rs.next()) {

                InputStream xmlInputStream = rs.getAsciiStream(1);

                int c;

                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                while ((c = xmlInputStream.read()) != -1) {
                    bos.write(c);
                }

                PrintStream pw = new PrintStream(new FileOutputStream("abc.xml"));

                pw.print(bos.toString());

                pw.close();
                bos.close();
                xmlInputStream.close();
            }

            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();

            System.out.println("XML Inserted and Retrieved Successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createXMLTable(Statement stmt) throws SQLException {

        System.out.println("Creating XML_DATA table...");

        try {
            stmt.executeUpdate("DROP TABLE XML_DATA");
        } catch (SQLException e) {
            // Ignore if table does not exist
        }

        String streamingDataSql =
                "CREATE TABLE XML_DATA(" +
                "ID NUMBER, " +
                "DATA LONG" +
                ")";

        stmt.executeUpdate(streamingDataSql);
    }
}