package main.persistence.dao;

import main.persistence.entities.CardType;
import java.util.List;

public interface CardTypeDAO {
    void create(CardType cardType);
    void update(CardType cardType);
    void delete(Long id);
    CardType findById(Long id);
    List<CardType> findAll();
}
