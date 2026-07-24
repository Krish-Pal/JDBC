package in.sp.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		 
		PreparedStatement ps = con.prepareStatement("select * from register");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("-------------------------------------------------------------------------");
			String name1 = rs.getString("name");
			String email1 = rs.getString("email");
			String gender1 = rs.getString("gender");
			String city1 = rs.getString("city");
			
			System.out.println("Name "+name1+" ,email "+ email1+", gender "+gender1+" ,city "+ city1+".");
			
			System.out.println("-------------------------------------------------------------------------");
		}
	}
}
