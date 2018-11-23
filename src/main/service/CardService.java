package main.service;

import main.persistence.entity.Transfer;
import org.apache.log4j.Logger;
import main.persistence.dao.CardDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.Card;
import java.util.Date;
import java.util.List;

public class CardService{
    private static final Logger LOGGER = Logger.getLogger(CardService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static CardService INSTANCE = new CardService();
    }

    public static CardService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createCard(Card card){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            cardDAO.create(card);
            LOGGER.info("createCard()");
        }
    }

    public void updateCard(Card card){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            cardDAO.update(card);
            LOGGER.info("updateCard()");
        }
    }

    public void deleteCard(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            cardDAO.delete(id);
            LOGGER.info("deleteCard() - " + id);
        }
    }

    public Card findCardById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            LOGGER.info("findCardById() - " + id);
            return cardDAO.findById(id);
        }
    }

    public List<Card> findAllCard(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            LOGGER.info("findAllCard()");
            return cardDAO.findAll();
        }
    }

    public boolean checkBalance(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);
            Card card = cardDAO.findById(transfer.getCardFrom().getId());
            LOGGER.info("checkBalance()");
            if (card.getBalance() >= transfer.getSum()){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean checkExpireDate(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDAO cardDAO = daoFactory.getCardDAO(connection);

            Card cardFrom = cardDAO.findById(transfer.getCardFrom().getId());
            Card cardTo = cardDAO.findById(transfer.getCardTo().getId());

            Date ExpireDateCardFrom = cardFrom.getExpiryDate();
            Date ExpireDateCardTo = cardTo.getExpiryDate();
            Date currentDate = new Date();

            boolean checkExpireDateCardFrom = currentDate.before(ExpireDateCardFrom);
            boolean checkExpireDateCardTo = currentDate.before(ExpireDateCardTo);

            LOGGER.info("checkExpireDate()");
            if (checkExpireDateCardFrom && checkExpireDateCardTo){
                return true;
            }
            else {
                return false;
            }
        }
    }
}
