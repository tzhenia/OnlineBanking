package main.persistence.factory.connection;

import main.persistence.exception.DaoException;
import main.persistence.factory.connection.enums.Error;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class MySqlConnection implements DaoConnection {

    private static final Logger logger = Logger.getLogger(MySqlConnection.class);

    private final Connection connection;
    private boolean isTransactionActive;

    public MySqlConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
            isTransactionActive = true;
        } catch (SQLException e) {
            logger.error(Error.DURING_START.value, e);
            throw new DaoException(e);
        }
    }
    @Override
    public void startSerializableTransaction() {
        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            isTransactionActive = true;
        } catch (SQLException e) {
            logger.error(Error.DURING_START.value, e);
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            isTransactionActive = false;
        } catch (SQLException e) {
            logger.error(Error.DURING_COMMIT.value, e);
            throw new DaoException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
            isTransactionActive = false;
        } catch (SQLException e) {
            logger.error(Error.DURING_ROLLBACK.value, e);
            throw new DaoException(e);
        }
    }

    @Override
    public void close() {
        if(isTransactionActive) {
            rollback();
        }

        try {
            if (connection != null) {
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(Error.DURING_CLOSE.value, e);
            throw new DaoException(e);
        }
    }

    @Override
    public Object getNativeConnection() {
        return connection;
    }
}