package main.persistence.datasource;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.util.ResourceBundle;
import main.persistence.datasource.enums.Db;

public class PooledConnection {

    private static class Singleton{
        static final DataSource INSTANCE = initDataSource();
    }

    public static DataSource getInstance(){
        return Singleton.INSTANCE;
    }

    private static DataSource initDataSource(){
        ResourceBundle bundle = ResourceBundle.getBundle(Db.BUNDLE.value);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(bundle.getString(Db.DRIVER.value));
        dataSource.setUrl(bundle.getString(Db.URL.value));
        dataSource.setUsername(bundle.getString(Db.USER.value));
        dataSource.setPassword(bundle.getString(Db.PASSWORD.value));
        return dataSource;
    }
}