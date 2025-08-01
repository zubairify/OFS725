import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareDemo {

	public static void main(String[] args) {
		// ? are place holders, index starts from 1
		String sql = "insert into cust values (?,?,?)";
		
		try (Connection conn = JdbcFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// Replacing place holders with values from Cmd line arguments
			stmt.setInt(1, Integer.parseInt(args[0]));
			stmt.setString(2, args[1]);
			stmt.setDouble(3, Double.parseDouble(args[2]));
			int rec = stmt.executeUpdate();
			System.out.println(rec + " records updated...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

