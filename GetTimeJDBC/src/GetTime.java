import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetTime {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREEPDB1","system","SYSTEM");
        Statement st = conn.createStatement();
        st.executeUpdate("create table survey113(id int, myData TIMESTAMP)");

        String INSERT_RECORD = "insert into survey113(id, myData) values(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
        pstmt.setInt(1,1);
        java.sql.Time sqlTime = new java.sql.Time(new java.util.Date().getTime());
        pstmt.setTime(2, sqlTime);
        pstmt.executeUpdate();
        ResultSet rs = st.executeQuery("select * from survey113");
        while(rs.next()) {
            System.out.println(rs.getTime(2));
        }
        rs.close();
        pstmt.close();
        st.close();
        conn.close();
 
    }
}
