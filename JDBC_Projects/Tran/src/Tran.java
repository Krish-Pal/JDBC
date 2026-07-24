import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Tran {

	public static void main(String []ss) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREEPDB1","system","SYSTEM");
			
			Statement s = c.createStatement();
			
			c.setAutoCommit(false);
			
			int x = s.executeUpdate("update emp101 set name = 'appsquadz' where pass = 'up' ");
			
			ResultSet result1 = s.executeQuery("select * from emp101 where pass = 'up' ");
			
			while(result1.next()) {
				System.out.print("name "+result1.getString(1));
				System.out.println("pass "+result1.getString(2) );
				
			}
			c.commit();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
