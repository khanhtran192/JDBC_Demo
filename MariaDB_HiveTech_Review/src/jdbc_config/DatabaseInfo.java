/**
 * khai bao cac String là thong tin de ket noi toi MariaDB server
 * java 12
 * @version 1.0
 * 25/9/2021
 * * @author Tran Duy Khanh
 */
package jdbc_config;

public class DatabaseInfo {
    public static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    public static final String DB_URL = "jdbc:mariadb://localhost:3306/mariaBD_Demo";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "19022001";

    private DatabaseInfo() {

    }
}
