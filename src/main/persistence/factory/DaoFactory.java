package main.persistence.factory;

import main.persistence.dao.*;
import main.persistence.exception.DaoException;
import main.persistence.factory.connection.DaoConnection;
import org.apache.log4j.Logger;
import java.util.ResourceBundle;

public abstract class DaoFactory {
    private static final String DB_BUNDLE = "database";
    private static final String DB_CLASS = "factory.class";
    private final static Logger logger = Logger.getLogger(DaoFactory.class);

    private static DaoFactory instance;

    /**
     * Gets factory class name from certain properties file.
     * Reflection used for more flexibility.
     *
     * @return specific implemented factory
     */
    public static DaoFactory getInstance() {
        if (instance == null) {
            ResourceBundle bundle = ResourceBundle.getBundle(DB_BUNDLE);
            String className = bundle.getString(DB_CLASS);
            try {
                instance = (DaoFactory) Class.forName(className).newInstance();
            } catch (Exception e) {
                logger.error(e);
                throw new DaoException(e);
            }
        }

        return instance;
    }

    public abstract DaoConnection getConnection();
    public abstract CardDAO getCardDAO(DaoConnection connection);
    public abstract CardTypeDAO getCardTypeDAO(DaoConnection connection);
    public abstract CreditLimitRequestDAO getCreditLimitRequestDAO(DaoConnection connection);
    public abstract StatusDAO getStatusDAO(DaoConnection connection);
    public abstract TransferDAO getTransferDAO(DaoConnection connection);
    public abstract TransferTypeDAO getTransferTypeDAO(DaoConnection connection);
    public abstract UserDAO getUserDAO(DaoConnection connection);
    public abstract UserRoleDAO getUserRoleDAO(DaoConnection connection);
}
