package main.persistence.factory;

import main.persistence.dao.*;
import main.persistence.dao.impl.*;
import main.persistence.datasource.PooledConnection;
import main.persistence.exception.DaoException;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.factory.connection.MySqlConnection;
import main.persistence.factory.connection.enums.Error;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDaoFactory extends DaoFactory {

    private DataSource dataSource = PooledConnection.getInstance();

    public DaoConnection getConnection() {
        try{
            return new MySqlConnection(dataSource.getConnection());
        } catch(SQLException e) {
           throw new DaoException(e);
        }
    }

    @Override
    public CardDAO getCardDAO(DaoConnection connection) {
        return new CardDAOImpl(getSqlConnection(connection));
    }

    @Override
    public CardTypeDAO getCardTypeDAO(DaoConnection connection) {
        return new CardTypeDAOImpl(getSqlConnection(connection));
    }

    @Override
    public CreditLimitRequestDAO getCreditLimitRequestDAO(DaoConnection connection) {
        return new CreditLimitRequestDAOImpl(getSqlConnection(connection));
    }

    @Override
    public StatusDAO getStatusDAO(DaoConnection connection) {
        return new StatusDAOImpl(getSqlConnection(connection));
    }

    @Override
    public TransferDAO getTransferDAO(DaoConnection connection) {
        return new TransferDAOImpl(getSqlConnection(connection));
    }

    @Override
    public TransferTypeDAO getTransferTypeDAO(DaoConnection connection) {
        return new TransferTypeDAOImpl(getSqlConnection(connection));
    }

    @Override
    public UserDAO getUserDAO(DaoConnection connection) {
        return new UserDAOImpl(getSqlConnection(connection));
    }

    @Override
    public UserRoleDAO getUserRoleDAO(DaoConnection connection) {
        return new UserRoleDAOImpl(getSqlConnection(connection));
    }

    private Connection getSqlConnection(DaoConnection connection) {
        checkDaoConnection(connection);
        return (Connection) connection.getNativeConnection();
    }

    private void checkDaoConnection(DaoConnection connection) {
        if(connection == null || connection.getNativeConnection() == null) {
            throw new DaoException(Error.NULLABLE_CONNECTION.value);
        }
        if(! (connection instanceof MySqlConnection)) {
            throw new DaoException(Error.WRONG_TYPE_CONNECTION.value);
        }
    }
}