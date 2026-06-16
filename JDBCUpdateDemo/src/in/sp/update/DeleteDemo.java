package in.sp.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {
	public static void main(String[] args) throws Exception {
		String name1 = "Krish";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
	
		PreparedStatement ps = con.prepareStatement("delete from register where name = ?");
		
		ps.setString(1,name1);
		
		int count = ps.executeUpdate();
		if(count > 0) {
			System.out.print("deleted successfully");
		} else {
			System.out.print("deleted failed..");
		}
	}
}
