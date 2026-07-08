import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Imageinsert {
    public static void main(String[] args) throws Exception {
       //class.forName("com.mysql.jdbc.Driver");
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREEPDB1","system","ROOT@123");

       Statement st = conn.createStatement();

       try {
           st.executeUpdate("drop table image18");
       } catch (Exception e) {
       }
       
       st.executeUpdate("create table image18(name varchar2(15), image blob)");

       File file = new File("baby.jpg");
       FileInputStream fis = new FileInputStream(file);
       PreparedStatement ps = conn.prepareStatement("insert into image18(name, image) values(?, ?)");
       ps.setString(1, "baby");
       ps.setBinaryStream(2, fis, (int) file.length());
       
       ps.executeUpdate();
       
       System.out.println("Image inserted successfully!"); 
       
       ps.close();
       fis.close();
       st.close();
       conn.close();
    }
}