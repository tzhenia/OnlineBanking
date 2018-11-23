package main.persistence.dao.impl;

import main.persistence.dao.CreditLimitRequestDAO;
import main.persistence.dao.impl.enums.CreditLimitRequestSQL;
import main.persistence.entity.CreditLimitRequest;
import main.persistence.entity.Card;
import main.persistence.entity.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditLimitRequestDAOImpl implements CreditLimitRequestDAO {
    private final Connection connection;

    public CreditLimitRequestDAOImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(CreditLimitRequest creditLimitRequest) {
        try (PreparedStatement statement = connection.prepareStatement(CreditLimitRequestSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, creditLimitRequest);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CreditLimitRequest creditLimitRequest) {
        try (PreparedStatement statement = connection.prepareStatement(CreditLimitRequestSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, creditLimitRequest);
            statement.setLong(4, creditLimitRequest.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(CreditLimitRequestSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CreditLimitRequest findById(Long id) {
        CreditLimitRequest creditLimitRequest = new CreditLimitRequest();

        try (PreparedStatement statement = connection.prepareStatement(CreditLimitRequestSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForCreditLimitRequest(rs, creditLimitRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditLimitRequest;
    }

    @Override
    public List<CreditLimitRequest> findAll() {
        List<CreditLimitRequest> creditLimitRequests = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(CreditLimitRequestSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CreditLimitRequest creditLimitRequest = new CreditLimitRequest();
                setValuesForCreditLimitRequest(rs, creditLimitRequest);
                creditLimitRequests.add(creditLimitRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditLimitRequests;
    }

    @Override
    public CreditLimitRequest setValuesForCreditLimitRequest(ResultSet rs, CreditLimitRequest creditLimitRequest) throws SQLException {
        creditLimitRequest.setId(rs.getLong("id"));
        creditLimitRequest.setCard(Card.newBuilder().setId(rs.getLong("id_card")).build());
        creditLimitRequest.setCreditLimit(rs.getDouble("credit_limit"));
        creditLimitRequest.setStatus(new Status(rs.getLong("s.id"), rs.getString("status")));
        return creditLimitRequest;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, CreditLimitRequest creditLimitRequest) throws SQLException {
        statement.setLong(1, creditLimitRequest.getCard().getId());
        statement.setDouble(2, creditLimitRequest.getCreditLimit());
        statement.setLong(3, creditLimitRequest.getStatus().getId());
        return statement;
    }
}
