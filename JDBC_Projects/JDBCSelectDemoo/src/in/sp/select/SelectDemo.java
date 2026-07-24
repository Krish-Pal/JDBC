package in.sp.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","ROOT@123");
		
		PreparedStatement ps = con.prepareStatement("select * from register");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String name1 = rs.getString("name");
			String  gender1 = rs.getString("gender");
			String email1 = rs.getString("email");
			String city1 = rs.getString("city");
			System.out.println("Name "+name1+", City "+city1+" ,Gender "+gender1+" ,Email "+ email1);
		}
		
	}
}












