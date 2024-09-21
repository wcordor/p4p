import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/p4p";
            String user = "root";
            String password = "1234";
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
