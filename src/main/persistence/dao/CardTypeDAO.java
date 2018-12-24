package main.persistence.dao;

import main.persistence.entities.CardType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CardTypeDAO {
    void create(CardType cardType);
    void update(CardType cardType);
    void delete(Long id);
    CardType findById(Long id);
    List<CardType> findAll();
    CardType setValuesForUser(ResultSet rs, CardType cardType) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, CardType cardType) throws SQLException;
}
