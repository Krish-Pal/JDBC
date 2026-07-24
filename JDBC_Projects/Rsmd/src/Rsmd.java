import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Rsmd {
    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/FREE",
                    "system",
                    "SYSTEM");

            Statement s = c.createStatement();

            ResultSet result1 = s.executeQuery("select * from emp101");

            ResultSetMetaData rsmd = result1.getMetaData();

            int count = rsmd.getColumnCount();

            System.out.println("Total Columns = " + count);

            for (int i = 1; i <= count; i++) {
            	System.out.println("---------------------------------");
                System.out.println("Column Name : " + rsmd.getColumnName(i));
                System.out.println("Data Type   : " + rsmd.getColumnTypeName(i));
            }

            result1.close();
            s.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}