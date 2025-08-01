import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) {
		
		String sql = "select * from cust";

		try (Connection conn = JdbcFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			// Firing select query returns results as Result set
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			for(int c=1; c <= meta.getColumnCount(); c++)
				System.out.print(meta.getColumnName(c) + "\t");
			
			System.out.println();
			
			// Traversing over result set
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" +
						rs.getString("cname") + "\t" +
						rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
