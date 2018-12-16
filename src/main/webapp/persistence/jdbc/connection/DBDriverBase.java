package main.webapp.persistence.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import main.webapp.persistence.logging.LoggerLoader;
public abstract class DBDriverBase {

    private final int fetchSize;
    public static final int CONNECTION_VALIDATION_TIMEOUT = 5;
    private static final Logger logger = LoggerLoader.getLogger(DBDriverBase.class);

    protected DBDriverBase() throws ClassNotFoundException {
        this.fetchSize = 20;
    }

    protected abstract String getDriverClass();
    protected abstract boolean registerDriver();

    protected void loadDriverClass(final String driverClassName) throws ClassNotFoundException{
        Class.forName(driverClassName);
    }

    public Connection getConnection(final String url, final String login, final String password) throws SQLException{
        return DriverManager.getConnection(url, login, password);
    }

    public Connection restoreConnection(Database conn) throws SQLException{
            if (conn.validate()) {
                return conn.getConnection();
            }
            return getConnection(conn.getUrl(), conn.getLogin(), conn.getPassword());
    }

    public int getFetchSize(){
        return fetchSize;
    }
}
