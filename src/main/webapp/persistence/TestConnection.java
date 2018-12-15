package jdbc;

import jdbc.connection.DBDriverBase;
import jdbc.connection.DBTypes;
import jdbc.connection.DBDriverFactory;
import jdbc.connection.Database;
import jdbc.core.Query;
import java.sql.ResultSet;
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DBDriverBase dbDriver = DBDriverFactory.createDriver(DBTypes.MYSQL);
        Database jdbcConn = new Database(dbDriver, "jdbc:mysql://localhost:3306/onlineBanking", "root", "rootroot");
        jdbcConn.connect();
        if (jdbcConn.validate()) {
            Query query = new Query(jdbcConn);
            ResultSet rs = query.executeQuery("select * from user");
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("first_name=" + rs.getString(2) + "; last_name=" + rs.getString(3) + ";");
                }
            }
        } else {
            System.out.println("Database connection error. See log file for more info.");
        }
    }

}
