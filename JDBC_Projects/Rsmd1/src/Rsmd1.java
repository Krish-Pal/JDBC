import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Rsmd1 {
	public static void main(String[] args) throws Exception {

		Connection conn = getOracleConnection();

		Statement st = conn.createStatement();
		st.executeUpdate("drop table survey");

		st.executeUpdate("create table survey (id number(4), name varchar2(30))");
		st.executeUpdate("Insert into survey(id, name) values (9,'meesa')");

		ResultSet rs = st.executeQuery("select * from survey");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int numberofColumn = rsMetaData.getColumnCount();
		System.out.println("result MetaDAta column Count = " + numberofColumn);

		for (int i = 1; i <= numberofColumn; i++) {

			System.out.println("Column MetaData");
			System.out.println("column number " + i);

			// indicates the designated column's normal maximum width in characters
			System.out.println(rsMetaData.getColumnDisplaySize(i));

			// gets the designated column's suggested title
			System.out.println(rsMetaData.getColumnLabel(i));

			// get the designated column's name
			System.out.println(rsMetaData.getColumnName(i));

			// get the designated column's SQL type.
			System.out.println(rsMetaData.getColumnType(i));

			// get the designated column's SQL type name.
			System.out.println(rsMetaData.getScale(i));

			// indicates whether the designated column is automatically numbered
			System.out.println(rsMetaData.isAutoIncrement(i));

			// Indicates whether the designated column is a currency value.
			System.out.println(rsMetaData.isCurrency(i));

			// indicates whether a write on the designated column will succeed.
			System.out.println(rsMetaData.isWritable(i));

			// indicates whether the designated column is definitely not writable.
			System.out.println(rsMetaData.isReadOnly(i));

			// Indicates whether a column's case matters.
			System.out.println(rsMetaData.isCaseSensitive(i));

			// Indicates whether the column can be used in a WHERE clause.
			System.out.println(rsMetaData.isSearchable(i));

			// indicates whether values are signed numbers.
			System.out.println(rsMetaData.isSigned(i));

			// gets the designated column's catalog name.
			System.out.println("Catalog name = " + rsMetaData.getCatalogName(i));

			// Gets the designated column's schema name.
			System.out.println("Schema name = " + rsMetaData.getSchemaName(i));
		}

		rs.close();
		st.close();
		conn.close();
	}

	public static Connection getOracleConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection c = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/FREE",
				"system",
				"SYSTEM");

		return c;
	}
}