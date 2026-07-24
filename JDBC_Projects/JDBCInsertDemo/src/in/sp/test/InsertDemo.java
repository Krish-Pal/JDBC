package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {

	public static void main(String []args) throws Exception {
		// ===========  user values =====================
		String name1 = "Munna";
		String email1 = "Krishpalpro@gmail.com";
		String pass1 = "Kakadev";
		String gender1 = "male";
		String city1 = "Shernagar";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
//		for(int j = 1; j < 100000; j++) {
			PreparedStatement ps = con.prepareStatement("Insert into register values(?,?,?,?)");
			ps.setString(1, name1);
			ps.setString(2, email1);
			ps.setString(3, gender1);
			ps.setString(4, city1);
			int i = ps.executeUpdate();
			
		if(i>0) {
			System.out.println("Success!!!");
		} else {
			System.out.println("Failed to store!!!");
		}	
//		}
	}
}











































































