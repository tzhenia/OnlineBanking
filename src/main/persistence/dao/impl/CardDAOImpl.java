package main.persistence.dao.impl;

import main.persistence.dao.CardDAO;
import main.persistence.dao.impl.enums.CardSQL;
import main.persistence.entities.Card;
import main.persistence.entities.CardType;
import main.persistence.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAOImpl implements CardDAO {
    private final Connection connection;

    public CardDAOImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Card card) {
        try (PreparedStatement statement = connection.prepareStatement(CardSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, card);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Card card) {
        try (PreparedStatement statement = connection.prepareStatement(CardSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, card);
            statement.setLong(10, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(CardSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Card findById(Long id) {
        Card card = new Card();

        try (PreparedStatement statement = connection.prepareStatement(CardSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForCard(rs, card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public List<Card> findAll() {
        List<Card> cards = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(CardSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                setValuesForCard(rs, card);
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public Card setValuesForCard(ResultSet rs, Card card) throws SQLException {
        card.setId(rs.getLong("id"));
        card.setUser(new User (rs.getLong("id_user")));
        card.setNumber(rs.getInt("number"));
        card.setCardType(new CardType(rs.getLong("id_card_type"), rs.getString("type")));
        card.setCardName(rs.getString("card_name"));
        card.setBalance(rs.getDouble("balance"));
        card.setCreditLimit(rs.getDouble("credit_limit"));
        card.setExpiryDate(rs.getDate("expiry_date"));
        card.setSumOfCredit(rs.getDouble("sum_of_credit"));
        card.setPercentValue(rs.getDouble("percent_value"));
        return card;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, Card card) throws SQLException {
        statement.setLong(1, card.getUser().getId());
        statement.setInt(2, card.getNumber());
        statement.setLong(3, card.getCardType().getId());
        statement.setString(4, card.getCardName());
        statement.setDouble(5, card.getBalance());
        statement.setDouble(6, card.getCreditLimit());
        statement.setString(7, card.getExpiryDate().toString());
        statement.setDouble(8, card.getSumOfCredit());
        statement.setDouble(9, card.getPercentValue());
        return statement;
    }
}
