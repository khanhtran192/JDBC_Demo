/**
 * Load Driver va tao ket noi toi database
 * java 12
 * @version 1.0
 * 25/9/2021
 * * @author Tran Duy Khanh
 */
package jdbc_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    // Load Driver + tao ket noi(Open Connection)
    public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName(DatabaseInfo.DRIVER_NAME);
        Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL, DatabaseInfo.DB_USER, DatabaseInfo.DB_PASSWORD);
        return connection;
    }
}
