import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class SensitiveResultSet {
	
	public static void main(String a[]) {
		Statement st = null;
		Statement st1 = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","ROOT@123");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			boolean b = dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
			System.out.println(b);
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITVE,ResultSet.
					CONCUR_UPDATETABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			
			st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			st.setFetchSize(1);
			MyThread1 t1 = new MyThread(st,st1);
			t1.start();
			
			
			
		} catch(Exception e) {
			
		}
	}
}