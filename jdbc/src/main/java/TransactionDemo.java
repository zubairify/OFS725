import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	
	public static void main(String[] args) {
		String sql1 = "insert into cust values (890,'Chikoo', 1000)";
		String sql2 = "update cust set cr_limit=5000 where cust_id=999";
		String sql3 = "delete from cust where cus_id=101";
		Connection conn = null;

		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			// Adding batch of SQL queries to perform at one go.
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			// Setting the auto-commit to false
			conn.setAutoCommit(false);
			
			// Executing all queries at once
			stmt.executeBatch();
			
			// Committing changes once everything goes fine
			conn.commit();
		} catch (SQLException e) {
			// If something goes wrong - rollback all
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
