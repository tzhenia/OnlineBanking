package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.CardTypeDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.CardType;
import java.util.List;

public class CardTypeService{
    private static final Logger LOGGER = Logger.getLogger(CardTypeService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static CardTypeService INSTANCE = new CardTypeService();
    }

    public static CardTypeService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createCardType(CardType cardType){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardTypeDAO cardTypeDAO = daoFactory.getCardTypeDAO(connection);
            cardTypeDAO.create(cardType);
            LOGGER.info("createCardType()");
        }
    }

    public void updateCardType(CardType cardType){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardTypeDAO cardTypeDAO = daoFactory.getCardTypeDAO(connection);
            cardTypeDAO.update(cardType);
            LOGGER.info("updateCardType()");
        }
    }

    public void deleteCardType(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardTypeDAO cardTypeDAO = daoFactory.getCardTypeDAO(connection);
            cardTypeDAO.delete(id);
            LOGGER.info("deleteCardType() - " + id);
        }
    }

    public CardType findCardTypeById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardTypeDAO cardTypeDAO = daoFactory.getCardTypeDAO(connection);
            LOGGER.info("findCardTypeById() - " + id);
            return cardTypeDAO.findById(id);
        }
    }

    public List<CardType> findAllCardType(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardTypeDAO cardTypeDAO = daoFactory.getCardTypeDAO(connection);
            LOGGER.info("findAllCardType()");
            return cardTypeDAO.findAll();
        }
    }
}
