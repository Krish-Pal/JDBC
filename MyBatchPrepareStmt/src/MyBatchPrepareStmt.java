import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyBatchPrepareStmt {
    public static void main(String a[]) {

        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/FREE",
                    "system",
                    "SYSTEM");

            Statement s = con.createStatement();

            pst = con.prepareStatement("update emp101 set name = ? where pass = ?");

            pst.setString(1, "codesquadz.o");
            pst.setString(2, "up");
            pst.addBatch();

            pst.setString(1, "micky");
            pst.setString(2, "manish");
            pst.addBatch();

            int count[] = pst.executeBatch();

            ResultSet result1 = s.executeQuery("select * from emp101");

            while (result1.next()) {
                System.out.println("Name " + result1.getString(1));
                System.out.println("Pass " + result1.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}