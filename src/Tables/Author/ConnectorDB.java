package Tables.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    public Connection connectDB() {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/online_library", "root", "admin");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return con;
    }
}
