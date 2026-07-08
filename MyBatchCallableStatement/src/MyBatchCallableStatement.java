import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyBatchCallableStatement {
	public static void main(String args[]) {
		CallableStatement callSt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/FREE",
					"system",
					"SYSTEM");
			
			Statement s = conn.createStatement();
					callSt = conn.prepareCall("{call recins88(?,?)}");
					callSt.setInt(1, 101);
					callSt.setString(2, "gadar");
					callSt.addBatch();
					callSt.setInt(1,909);
					callSt.setString(2, "cheetah909");
					callSt.addBatch();
					int[] updateCounts = callSt.executeBatch();
					ResultSet result1 = s.executeQuery("select * from emp65");
					
					while(result1.next()) {
						System.out.println("ID "+result1.getString(1));
						System.out.println("name "+result1.getString(2));
					}
							
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}