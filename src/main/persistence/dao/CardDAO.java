package main.persistence.dao;

import main.persistence.entities.Card;
import java.util.List;

public interface CardDAO {
    void create(Card card);
    void update(Card card);
    void delete(Long id);
    Card findById(Long id);
    List<Card> findAll();
}
