package main.persistence.dao;

import main.persistence.entities.Card;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CardDAO {
    void create(Card card);
    void update(Long id, Card card);
    void delete(Long id);
    Card findById(Long id);
    List<Card> findAll();
    Card setValuesForCard(ResultSet rs, Card card) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, Card card) throws SQLException;
}
