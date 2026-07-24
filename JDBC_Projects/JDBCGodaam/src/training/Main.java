package training;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");

	
	
	}
}
