import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Tran1 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free","system","SYSTEM");
			
			Statement s = c.createStatement();
			
			c.setAutoCommit(false);
			
			int x = s.executeUpdate("update emp101 set name = 'appsquadz2.o' where pass  = 'up'  ");
			ResultSet result1 = s.executeQuery("select * from emp101 here pass = 'codesquadz' ");
			
			while(result1.next()) {
				System.out.println("id :"+ result1.getString(1));
				System.out.println("name "+result1.getString(2));
			}
			c.rollback();
			System.out.println("after roolback");
			ResultSet result2 = s.executeQuery("select * from emp101 where pass = 'codeSquadz' ");
			
			while(result2.next()) {
				System.out.println("id: "+ result2.getString(1));
				System.out.println("name "+result2.getString(2));
			}
			
			c.commit();
			
		} catch(Exception e) {
			
		}
	}
}
