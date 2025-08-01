import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcFactory {
    private JdbcFactory() {}

    public static Connection getConnection() throws SQLException {
        try {
            Properties props = new Properties();
            props.load(new FileReader("dbinfo.txt"));
            String driverClass = props.getProperty("driverClass");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");

            Class.forName(driverClass);

            Connection conn = DriverManager.getConnection(
                url,user,pass);
            return conn;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
}
