import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSql {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","manish");

            String t1 = "lalu";
            int t2 = 420;
            
            Statement s = c.createStatement();
            s.executeUpdate("create table emp162(name varchar(20), salary int)");
            s.close();
            PreparedStatement ps = c.prepareStatement("insert into emp162 values(?,?)");
            ps.setString(1, t1);
            ps.setInt(2,t2);
            ps.executeUpdate();
            ps.close();
            ps = c.prepareStatement(("select * from emp162 where salary=?"));
            ps.setInt(1,t2);
            ResultSet result1 = ps.executeQuery();
            while(result1.next()) {
                System.out.println("name" + result1.getString(1));
                System.out.println("salary" + result1.getString(2));
            }
            result1.close();
            ps.close();
            c.close();
        } catch(SQLException e) {
            System.out.println(e);
        } catch(Exception i){
            System.out.println(i);
        }
    }
}
