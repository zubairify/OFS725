import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		
		String sql = "insert into cust values (999,'Sam',2000)";

		try(Connection conn = JdbcFactory.getConnection()) {
			// Creating statement to perform fixed query
			Statement stmt = conn.createStatement();
			// Performing DML operation
			int rec = stmt.executeUpdate(sql);
			System.out.println(rec + " records updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
