import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectionDemo {
    public static void main(String[] args) throws Exception {
        String driverClass = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";

//        Class.forName(driverClass);
//        Connection conn = DriverManager.getConnection(
//                url,"zubair","oracle");
        Connection conn = JdbcFactory.getConnection();
        System.out.println("Connected to database successfully");

        DatabaseMetaData meta = conn.getMetaData();
        System.out.println("Driver name: " + meta.getDriverName());
        System.out.println("Driver version: " + meta.getDriverVersion());
        System.out.println("DB name: " + meta.getDatabaseProductName());
        System.out.println("DB version: " + meta.getDatabaseProductVersion());
    }
}
