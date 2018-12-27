package main.persistence.dao.impl;

import main.persistence.dao.CardTypeDAO;
import main.persistence.dao.impl.enums.CardTypeSQL;
import main.persistence.entities.CardType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardTypeDAOImpl implements CardTypeDAO {
    private final Connection connection;

    public CardTypeDAOImpl(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(CardType cardType) {
        try (PreparedStatement statement = connection.prepareStatement(CardTypeSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, cardType);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, CardType cardType) {
        try (PreparedStatement statement = connection.prepareStatement(CardTypeSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, cardType);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(CardTypeSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CardType findById(Long id) {
        CardType cardType = new CardType();

        try (PreparedStatement statement = connection.prepareStatement(CardTypeSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForCardType(rs, cardType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardType;
    }

    @Override
    public List<CardType> findAll() {
        List<CardType> cardTypes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(CardTypeSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CardType cardType = new CardType();
                setValuesForCardType(rs, cardType);
                cardTypes.add(cardType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardTypes;
    }

    @Override
    public CardType setValuesForCardType(ResultSet rs, CardType cardType) throws SQLException {
        cardType.setId(rs.getLong("id"));
        cardType.setType(rs.getString("type"));
        return cardType;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, CardType cardType) throws SQLException {
        statement.setString(1, cardType.getType());
        return statement;
    }
}
