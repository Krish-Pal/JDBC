import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Savepoint; // 1. Added missing import

public class SavePoint {

	public static void main(String[] args) { // 2. Wrapped block in main method
		try {
			// 3. Fixed the driver string format (colons to dots)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREE",
					"system","SYSTEM");
			Statement s = c.createStatement();
			
			c.setAutoCommit(false);
			
			int x = s.executeUpdate("update emp101 set name = 'appsquadz.0' where pass = 'up'");
			
			s.executeUpdate("insert into emp101 values ('dhonicsk','dhonicsk')");
			
			// 4. Fixed the Savepoint cast. Your class is SavePoint, the SQL interface is Savepoint.
			Savepoint savept = c.setSavepoint("aaa");
			
			int x1 = s.executeUpdate("delete from emp101 where pass = 'manish' ");
			s.executeUpdate("insert into emp101 values('pappa','rahul')");
			
			c.rollback(savept);
			
			// c.releaseSavepoint(savept); // Fixed typo in your comment
			
			c.commit();
			
			ResultSet result1 = s.executeQuery("select * from emp101");
			
			while(result1.next()) {
				System.out.println("id :"+result1.getString(1));
				System.out.println("name :" +result1.getString(2));
			}
			
		} catch(Exception e) {
			System.out.println(e); // Removed quotes around 'e' so it prints the actual error if it fails
		}
	}
}