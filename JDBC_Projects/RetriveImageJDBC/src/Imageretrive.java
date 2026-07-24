import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Imageretrive {
    public static void main(String[] args) throws Exception{
        
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREEPDB1","system","ROOT@123");

    PreparedStatement ps = conn.prepareStatement("select image from image18 where name = ?");
    ps.setString(1,"baby");
    ResultSet rs = ps.executeQuery();
    rs.next();
    InputStream f = rs.getBinaryStream("image");
    FileOutputStream f1 = new FileOutputStream("baby.jpg");
    int i = 0;
    while((i = f.read()) != -1)
        f1.write(i);
    f.close();
    f1.close();
    rs.close();
    ps.close();
    conn.close();
    }
}
