package main.persistence;

import main.persistence.connection.DBDriverBase;
import main.persistence.connection.DBTypes;
import main.persistence.connection.DBDriverFactory;
import main.persistence.connection.Database;
import main.persistence.dao.impl.*;
import main.persistence.dao.impl.enums.CardPercentValue;
import main.persistence.entities.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        DBDriverBase dbDriver = DBDriverFactory.createDriver(DBTypes.MYSQL);
        Database jdbcConn = new Database(dbDriver, "jdbc:mysql://localhost:3306/onlineBanking", "rootroot", "root");
        jdbcConn.connect();
        UserDAOImpl userDAOImpl = new UserDAOImpl(jdbcConn.getConnection());
        UserRoleDAOImpl userRoleDAOImpl = new UserRoleDAOImpl(jdbcConn.getConnection());
        CardTypeDAOImpl cardTypeDAOImpl = new CardTypeDAOImpl(jdbcConn.getConnection());
        TransferTypeDAOImpl transferTypeDAOImpl = new TransferTypeDAOImpl(jdbcConn.getConnection());
        StatusDAOImpl statusDAOImpl = new StatusDAOImpl(jdbcConn.getConnection());
        CreditLimitRequestDAOImpl creditLimitRequestDAOImpl = new CreditLimitRequestDAOImpl(jdbcConn.getConnection());
        CardDAOImpl cardDAOImpl = new CardDAOImpl(jdbcConn.getConnection());
        TransferDAOImpl transferDAOImpl = new TransferDAOImpl(jdbcConn.getConnection());

        if (jdbcConn.validate()) {
            // TEST DAO User
            // createUser(userDAOImpl);
            // updateUser(userDAOImpl, 2L);
            // deleteUser(userDAOImpl, 6L);
            // findUserById(userDAOImpl, 2L);
            // findAllUser(userDAOImpl);

            // TEST DAO UserRole
            // createUserRole(userRoleDAOImpl);
            // updateUserRole(userRoleDAOImpl, 4L);
            // deleteUserRole(userRoleDAOImpl, 3L);
            // findUserRoleById(userRoleDAOImpl, 1L);
            // findAllUserRole(userRoleDAOImpl);

            // TEST DAO CardType
            // createCardType(cardTypeDAOImpl);
            // updateCardType(cardTypeDAOImpl, 3L);
            // deleteCardType(cardTypeDAOImpl, 3L);
            // findCardTypeById(cardTypeDAOImpl, 3L);
            // findAllCardType(cardTypeDAOImpl);

            // TEST DAO TransferType
            // createTransferType(transferTypeDAOImpl);
            // updateTransferType(transferTypeDAOImpl, 3L);
            // deleteTransferType(transferTypeDAOImpl, 5L);
            // findTransferTypeById(transferTypeDAOImpl, 4L);
            // findAllTransferType(transferTypeDAOImpl);

            // TEST DAO Status
            // createStatus(statusDAOImpl);
            // updateStatus(statusDAOImpl, 5L);
            // deleteStatus(statusDAOImpl, 5L);
            // findStatusById(statusDAOImpl, 4L);
            // findAllStatus(statusDAOImpl);

            // TEST DAO Status
            // createCreditLimitRequest(creditLimitRequestDAOImpl);
            // updateCreditLimitRequest(creditLimitRequestDAOImpl, 5L);
            // deleteCreditLimitRequest(creditLimitRequestDAOImpl, 5L);
            // findCreditLimitRequestById(creditLimitRequestDAOImpl, 2L);
            // findAllCreditLimitRequest(creditLimitRequestDAOImpl);

            // TEST DAO Card
            // createCard(cardDAOImpl);
            // updateCard(cardDAOImpl, 5L);
            // deleteCard(cardDAOImpl, 8L);
            // findCardById(cardDAOImpl, 2L);
            // findAllCard(cardDAOImpl);

            // TEST DAO Transfer
            // createTransfer(transferDAOImpl);
            // updateTransfer(transferDAOImpl, 1L);
            // deleteTransfer(transferDAOImpl, 6L);
            // findTransferById(transferDAOImpl, 3L);
            // findAllTransfer(transferDAOImpl);

        } else {
            System.out.println("Database connection error. See log file for more info.");
        }
    }

    // TEST DAO User
    private static void createUser(UserDAOImpl userDAOImpl) throws Exception {
        String date = "1993-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        UserRole role = new UserRole(2L, "TEST");

        User user = new User(99L, "tzhenia111112233", 111, "111", "Женя2", "Женя", "Женя 3", dateDB, role);
        userDAOImpl.create(user);
    }

    private static void updateUser(UserDAOImpl userDAOImpl, Long id) throws Exception {
        String date = "1293-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        UserRole role = new UserRole(2L, "TEST");
        User user = new User(999L, "new_tzhenia11111223300000", 1000, "new_3399990", "new_Женя2", "new_Женя", "new_Женя 3", dateDB, role);
        userDAOImpl.update(id, user);
    }

    private static void deleteUser(UserDAOImpl userDAOImpl, Long id) throws Exception {
        userDAOImpl.delete(id);
    }

    private static void findUserById(UserDAOImpl userDAOImpl, Long id) throws Exception {
        User user = userDAOImpl.findById(id);
        System.out.println(user.toString());
    }

    private static void findAllUser(UserDAOImpl userDAOImpl) throws Exception {
        List<User> users = userDAOImpl.findAll();
        for (User item : users) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO UserRole
    private static void createUserRole(UserRoleDAOImpl userRoleDAOImpl) throws Exception {
        UserRole role = new UserRole(99L, "TEST added UserRole");
        userRoleDAOImpl.create(role);
    }

    private static void updateUserRole(UserRoleDAOImpl userRoleDAOImpl, Long id) throws Exception {
        UserRole userRole = new UserRole(99L, "TEST update UserRole!!");
        userRoleDAOImpl.update(id, userRole);
    }

    private static void deleteUserRole(UserRoleDAOImpl userRoleDAOImpl, Long id) throws Exception {
        userRoleDAOImpl.delete(id);
    }

    private static void findUserRoleById(UserRoleDAOImpl userRoleDAOImpl, Long id) throws Exception {
        UserRole userRole = userRoleDAOImpl.findById(id);
        System.out.println(userRole.toString());
    }

    private static void findAllUserRole(UserRoleDAOImpl userRoleDAOImpl) throws Exception {
        List<UserRole> roles = userRoleDAOImpl.findAll();
        for (UserRole item : roles) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO CardType
    private static void createCardType(CardTypeDAOImpl cardTypeDAOImpl) throws Exception {
        CardType cardType = new CardType(99L, "TEST added cardType");
        cardTypeDAOImpl.create(cardType);
    }

    private static void updateCardType(CardTypeDAOImpl cardTypeDAOImpl, Long id) throws Exception {
        CardType cardType = new CardType(99L, "TEST update");
        cardTypeDAOImpl.update(id, cardType);
    }

    private static void deleteCardType(CardTypeDAOImpl cardTypeDAOImpl, Long id) throws Exception {
        cardTypeDAOImpl.delete(id);
    }

    private static void findCardTypeById(CardTypeDAOImpl cardTypeDAOImpl, Long id) throws Exception {
        CardType cardType = cardTypeDAOImpl.findById(id);
        System.out.println(cardType.toString());
    }

    private static void findAllCardType(CardTypeDAOImpl cardTypeDAOImpl) throws Exception {
        List<CardType> roles = cardTypeDAOImpl.findAll();
        for (CardType item : roles) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO TransferType
    private static void createTransferType(TransferTypeDAOImpl transferTypeDAOImpl) throws Exception {
        TransferType transferType = new TransferType(99L, "TEST2 TransferType");
        transferTypeDAOImpl.create(transferType);
    }

    private static void updateTransferType(TransferTypeDAOImpl transferTypeDAOImpl, Long id) throws Exception {
        TransferType transferType = new TransferType(99L, "TEST update !");
        transferTypeDAOImpl.update(id, transferType);
    }

    private static void deleteTransferType(TransferTypeDAOImpl transferTypeDAOImpl, Long id) throws Exception {
        transferTypeDAOImpl.delete(id);
    }

    private static void findTransferTypeById(TransferTypeDAOImpl transferTypeDAOImpl, Long id) throws Exception {
        TransferType transferType = transferTypeDAOImpl.findById(id);
        System.out.println(transferType.toString());
    }

    private static void findAllTransferType(TransferTypeDAOImpl transferTypeDAOImpl) throws Exception {
        List<TransferType> transferTypes = transferTypeDAOImpl.findAll();
        for (TransferType item : transferTypes) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO Status
    private static void createStatus(StatusDAOImpl statusDAOImpl) throws Exception {
        Status status = new Status(99L, "TEST2 Status");
        statusDAOImpl.create(status);
    }

    private static void updateStatus(StatusDAOImpl statusDAOImpl, Long id) throws Exception {
        Status status = new Status(99L, "TEST RRR!");
        statusDAOImpl.update(id, status);
    }

    private static void deleteStatus(StatusDAOImpl statusDAOImpl, Long id) throws Exception {
        statusDAOImpl.delete(id);
    }

    private static void findStatusById(StatusDAOImpl statusDAOImpl, Long id) throws Exception {
        Status status = statusDAOImpl.findById(id);
        System.out.println(status.toString());
    }

    private static void findAllStatus(StatusDAOImpl statusDAOImpl) throws Exception {
        List<Status> status = statusDAOImpl.findAll();
        for (Status item : status) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO CreditLimitRequest
    private static void createCreditLimitRequest(CreditLimitRequestDAOImpl creditLimitRequestDAOImpl) throws Exception {
        CreditLimitRequest creditLimitRequest = new CreditLimitRequest(99L, new Card(5L), 200d, new Status(2L, "dsds"));
        creditLimitRequestDAOImpl.create(creditLimitRequest);
    }

    private static void updateCreditLimitRequest(CreditLimitRequestDAOImpl creditLimitRequestDAOImpl, Long id) throws Exception {
        CreditLimitRequest creditLimitRequest = new CreditLimitRequest(99L, new Card(3L), 111d, new Status(1L, "dsds"));
        creditLimitRequestDAOImpl.update(id, creditLimitRequest);
    }

    private static void deleteCreditLimitRequest(CreditLimitRequestDAOImpl creditLimitRequestDAOImpl, Long id) throws Exception {
        creditLimitRequestDAOImpl.delete(id);
    }

    private static void findCreditLimitRequestById(CreditLimitRequestDAOImpl creditLimitRequestDAOImpl, Long id) throws Exception {
        CreditLimitRequest creditLimitRequest = creditLimitRequestDAOImpl.findById(id);
        System.out.println(creditLimitRequest.toString());
    }

    private static void findAllCreditLimitRequest(CreditLimitRequestDAOImpl creditLimitRequestDAOImpl) throws Exception {
        List<CreditLimitRequest> creditLimitRequest = creditLimitRequestDAOImpl.findAll();
        for (CreditLimitRequest item : creditLimitRequest) {
            System.out.println(item.toString());
        }
    }

    // TEST DAO Card
    private static void createCard(CardDAOImpl cardDAOImpl) throws Exception {
        User user= new User(1L);
        CardType cardType = new CardType(1L, "Name");

        String date = "2020-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        Card card = new Card(99L, user, 1000000001, cardType, "Card Name", 0d, 0d, dateDB, 0d, CardPercentValue.CREDIT_STANDART.PERCENT_VALUE);
        cardDAOImpl.create(card);
    }

    private static void updateCard(CardDAOImpl cardDAOImpl, Long id) throws Exception {
        User user= new User(1L);
        CardType cardType = new CardType(1L, "Name");

        String date = "2020-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        Card card = new Card(99L, user, 1000000001, cardType, "Card Name", 0d, 0d, dateDB, 0d, CardPercentValue.CREDIT_STANDART.PERCENT_VALUE);
        cardDAOImpl.update(id, card);
    }

    private static void deleteCard(CardDAOImpl cardDAOImpl, Long id) throws Exception {
        cardDAOImpl.delete(id);
    }

    private static void findCardById(CardDAOImpl cardDAOImpl, Long id) throws Exception {
        Card card = cardDAOImpl.findById(id);
        System.out.println(card.toString());
    }

    private static void findAllCard(CardDAOImpl cardDAOImpl) throws Exception {
        List<Card> cards = cardDAOImpl.findAll();
        for (Card item : cards) {
            System.out.println(item.toString());
        }
    }


    // TEST DAO Transfer
    private static void createTransfer(TransferDAOImpl transferDAOImpl) throws Exception {
        Card cardFrom = new Card(1L);
        Card cardTo = new Card(5L);
        TransferType transferType = new TransferType(1L, "Name");
        Status status = new Status(1L, "dsds");

        String date = "2020-03-31 22:11:01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        Transfer transfer = new Transfer(99L, cardFrom, cardTo, 100d, "test note", transferType, status, dateDB);transferDAOImpl.create(transfer);
    }

    private static void updateTransfer(TransferDAOImpl transferDAOImpl, Long id) throws Exception {
        Card cardFrom = new Card(1L);
        Card cardTo = new Card(6L);
        TransferType transferType = new TransferType(2L, "Name");
        Status status = new Status(3L, "dsds");

        String date = "2020-03-31 22:10:01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        Transfer transfer = new Transfer(99L, cardFrom, cardTo, 222d, "test note new", transferType, status, dateDB);
        transferDAOImpl.update(id, transfer);
    }

    private static void deleteTransfer(TransferDAOImpl transferDAOImpl, Long id) throws Exception {
        transferDAOImpl.delete(id);
    }

    private static void findTransferById(TransferDAOImpl transferDAOImpl, Long id) throws Exception {
        Transfer transfer = transferDAOImpl.findById(id);
        System.out.println(transfer.toString());
    }

    private static void findAllTransfer(TransferDAOImpl transferDAOImpl) throws Exception {
        List<Transfer> transfers = transferDAOImpl.findAll();
        for (Transfer item : transfers) {
            System.out.println(item.toString());
        }
    }
}