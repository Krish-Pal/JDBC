package in.sp.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {
	
	public static void main(String[] args) throws Exception {
		String email1 = "kamal@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","ROOT@123");
	
		PreparedStatement ps = con.prepareStatement("delete from register where email = ? ");
			
		ps.setString(1,email1 );
		
		int count = ps.executeUpdate();
		 
		if(count > 0) {
			System.out.println("delete success");
			
		} else {
			System.out.println("deletion failed");
		}
	}

}
