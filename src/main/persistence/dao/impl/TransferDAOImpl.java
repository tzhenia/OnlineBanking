package main.persistence.dao.impl;

import main.persistence.dao.TransferDAO;
import main.persistence.dao.impl.enums.TransferSQL;
import main.persistence.entities.Card;
import main.persistence.entities.Status;
import main.persistence.entities.Transfer;
import main.persistence.entities.TransferType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferDAOImpl implements TransferDAO {
    private final Connection connection;

    public TransferDAOImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Transfer transfer) {
        try (PreparedStatement statement = connection.prepareStatement(TransferSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, transfer);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Transfer transfer) {
        try (PreparedStatement statement = connection.prepareStatement(TransferSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, transfer);
            statement.setLong(8, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(TransferSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transfer findById(Long id) {
        Transfer transfer = new Transfer();

        try (PreparedStatement statement = connection.prepareStatement(TransferSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForTransfer(rs, transfer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transfer;
    }

    @Override
    public List<Transfer> findAll() {
        List<Transfer> transfers = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(TransferSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Transfer transfer = new Transfer();
                setValuesForTransfer(rs, transfer);
                transfers.add(transfer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transfers;
    }

    @Override
    public Transfer setValuesForTransfer(ResultSet rs, Transfer transfer) throws SQLException {
        transfer.setId(rs.getLong("id"));
        transfer.setCardFrom(new Card(rs.getLong("id_card_from")));
        transfer.setCardTo(new Card(rs.getLong("id_card_to")));
        transfer.setSum(rs.getDouble("sum"));
        transfer.setNote(rs.getString("note"));
        transfer.setTransferType(new TransferType(rs.getLong("id_transfer_type")));
        transfer.setStatus(new Status(rs.getLong("id_status"),rs.getString("status")));
        transfer.setDate(rs.getDate("time"));
        return transfer;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, Transfer transfer) throws SQLException {
        statement.setLong(1, transfer.getCardFrom().getId());
        statement.setLong(2, transfer.getCardTo().getId());
        statement.setDouble(3, transfer.getSum());
        statement.setString(4, transfer.getNote());
        statement.setLong(5, transfer.getTransferType().getId());
        statement.setLong(6, transfer.getStatus().getId());
        statement.setString(7, transfer.getDate().toString());
        return statement;
    }
}
