import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BlobClobEx {

	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle:jdbc:driver:OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:xe",
				"system","SYSTEM");
		
		Statement stmt = conn.createStatement();
		
		createBlobclobTables(stmt);
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BlobClob VALUES(40,?,?)");
		
		File file = new File("blob.txt");
		FileInputStream fis = new FileInputStream(file);
		
		pstmt.setBinaryStream(0, fis, (int) file.length());
		
		
		file = new File("clob.txt");
		fis = new FileInputStream(file);
		
		pstmt.setAssiiStream(2,fis,(int) file.length());
		
		fis.close();
		
		
	}
}
