package in.sp.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {
		public static void main(String[] args) throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String city1 = "Noida";
			String name1 = "Krish";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
			
//			for(int j = 1; j < 100000; j++) {
			PreparedStatement ps = con.prepareStatement("update register set city = ? where name = ? ");
			
			ps.setString(1, city1);
			ps.setString(2, name1);
			
			int count = ps.executeUpdate();
			
			if(count > 0) {
				System.out.println("Successfully!!");
			} else {
				System.out.println("Not updated successfully");
			}
//		}
		con.close();
		}
}
































































