import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    public Connection dbLink;

    public Connection getConnection() {
        String dbName = "localdb";
        String dbUser = "testuser";
        String dbPassword = "testpassword";
        String url = "jdbc:mysql://localhost/" + dbName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbLink;
    }
}
