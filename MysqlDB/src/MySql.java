import java.sql.*;


public class MySql {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db",
    				"root",
    				"ROOT@123");

            String t1 = "lalu";
            int t2 = 420;

            PreparedStatement ps = c.prepareStatement("insert into emp162 values(?, ?)");
            ps.setString(1, t1);
            ps.setInt(2, t2);

            ps.executeUpdate();

            ps.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
