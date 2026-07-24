import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetJDBCTypeName {

	public static void main(String args[])  throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free",
				"system","SYSTEM");
		
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet resultSet = dbmd.getTypeInfo();
		
		while(resultSet.next()) {
			String typeName = resultSet.getString("TYPE_NAME");
			
			short dataType = resultSet.getShort("DATA_TYPE");
			
			System.out.println(typeName+" = "+dataType);
			
		}
		
	}
	
}
