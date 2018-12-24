package main.persistence.dao.impl;

import main.persistence.dao.TransferTypeDAO;
import main.persistence.dao.impl.enums.TransferTypeSQL;
import main.persistence.entities.TransferType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferTypeDAOImpl implements TransferTypeDAO {
    private final Connection connection;

    public TransferTypeDAOImpl(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(TransferType transferType) {
        try (PreparedStatement statement = connection.prepareStatement(TransferTypeSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, transferType);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, TransferType transferType) {
        try (PreparedStatement statement = connection.prepareStatement(TransferTypeSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, transferType);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(TransferTypeSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TransferType findById(Long id) {
        TransferType transferType = new TransferType();

        try (PreparedStatement statement = connection.prepareStatement(TransferTypeSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForTransferType(rs, transferType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transferType;
    }

    @Override
    public List<TransferType> findAll() {
        List<TransferType> transferTypes = new ArrayList<TransferType>();

        try (PreparedStatement statement = connection.prepareStatement(TransferTypeSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TransferType transferType = new TransferType();
                setValuesForTransferType(rs, transferType);
                transferTypes.add(transferType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transferTypes;
    }

    @Override
    public TransferType setValuesForTransferType(ResultSet rs, TransferType transferType) throws SQLException {
        transferType.setId(rs.getLong("id"));
        transferType.setTransferType(rs.getString("type"));
        return transferType;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, TransferType transferType) throws SQLException {
        statement.setString(1, transferType.getTransferType());
        return statement;
    }
}