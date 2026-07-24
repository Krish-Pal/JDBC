package in.orignal.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo   {
	
	public static void main(String[] args) throws Exception {
		
		String name1 = "kamal";
		String email1 = "kamal@gmail.com";
//		String pass1 = "Kamal123";
		String gender1 = "famale";
		String city1 = "kolkata";
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver class loaded successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db",
				"root",
				"ROOT@123");
		System.out.println("Connection built");
		
	
		
		PreparedStatement ps = con.prepareStatement(
				"insert into register values(?,?,?,?)"
				);
		ps.setString(1,name1);
		ps.setString(2,email1);
//		ps.setString(3,pass1);
		ps.setString(3,gender1);
		ps.setString(4,city1);
		
		 int i = ps.executeUpdate();
		 
		 if(i > 0) {
			 System.out.println("success");
		 } else {
			 System.out.println("fail");
		 }
	}

}













 
