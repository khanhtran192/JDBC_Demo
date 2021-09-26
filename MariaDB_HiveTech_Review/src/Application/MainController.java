/**
 * ham main
 * java 12
 * @version25/9/2021
 * * @author Tran Duy Khanh
 */
package Application;

import java.sql.SQLException;

public class MainController extends ControllerJDBC{
    public static void main(String[] args) {
        ControllerJDBC ctl_jdbc = new ControllerJDBC();
        try {
            ctl_jdbc.menu();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
