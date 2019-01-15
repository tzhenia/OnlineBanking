package main.service;

import main.persistence.entity.Card;
import main.persistence.entity.Status;
import main.persistence.entity.TransferType;
import org.apache.log4j.Logger;
import main.persistence.dao.TransferDAO;
import main.persistence.dao.CardDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.Transfer;
import java.util.Date;
import java.util.List;

public class TransferService {
    private static final Logger LOGGER = Logger.getLogger(TransferService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static TransferService INSTANCE = new TransferService();
    }

    public static TransferService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createTransfer(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            transferDAO.create(transfer);
            LOGGER.info("createTransfer()");
        }
    }

    public void updateTransfer(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            transferDAO.update(transfer);
            LOGGER.info("deleteTransfer() - " + transfer.getId());
        }
    }

    public void deleteTransfer(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            transferDAO.delete(id);
            LOGGER.info("deleteTransfer() - " + id);
        }
    }

    public Transfer findTransferById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            LOGGER.info("findTransferById() - " + id);
            return transferDAO.findById(id);
        }
    }

    public List<Transfer> findAllTransfer(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            LOGGER.info("findAllTransfer()");
            return transferDAO.findAll();
        }
    }

    public List<Transfer> findAllTransferByIdCardFrom(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            LOGGER.info("findAllTransferByIdCardFrom() - " + id);
            return transferDAO.findAllByIdCardFrom(id);
        }
    }

    public List<Transfer> findAllTransferByIdCardTo(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            LOGGER.info("findAllTransferByIdCardTo() - " + id);
            return transferDAO.findAllByIdCardTo(id);
        }
    }

    public void doTransfer(Transfer transfer){
        boolean check = isItPossibleToTransfer(transfer);
        if(check){
            try(DaoConnection connection = daoFactory.getConnection()) {

                connection.startSerializableTransaction();
                    createTransfer(transfer);
                    increaseBalance(transfer);
                    decreaseBalance(transfer);
                connection.commit();

                LOGGER.info("doTransfer() - Card ID from " + transfer.getCardFrom().getId() + ", Card ID to " + transfer.getCardTo().getId());
            }
        }
    }

    private boolean isItPossibleToTransfer(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {

            boolean checkBalance = CardService.getInstance().checkBalance(transfer);
            boolean checkExpireDate = CardService.getInstance().checkExpireDate(transfer);

            if(checkBalance && checkExpireDate){
                return true;
            }
            else {
                LOGGER.info("isItPossibleToTransfer() - Can't transfer. " + "Balance: " + checkBalance + ", ExpireDate: " + checkExpireDate);
                return false;
            }
        }
    }

    private void increaseBalance(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            transferDAO.increaseBalance(transfer);
            LOGGER.info("increaseBalance()");
        }
    }

    private void decreaseBalance(Transfer transfer){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferDAO transferDAO = daoFactory.getTransferDAO(connection);
            transferDAO.decreaseBalance(transfer);
            LOGGER.info("decreaseBalance()");
        }
    }

    public static void main(String[] args) throws Exception{
        TransferService transferService = TransferService.getInstance();
        CardService cardService = CardService.getInstance();

        Card cardFrom = cardService.findCardById(1L);
        Card cardTo =  cardService.findCardById(4L);

        Transfer transfer = Transfer.newBuilder()
                .setCardFrom(cardFrom)
                .setCardTo(cardTo)
                .setSum(10000000000D)
                .setNote("TEST")
                .setTransferType(new TransferType(1L))
                .setStatus(new Status(1L))
                .setDate(new Date())
                .build();
        transferService.doTransfer(transfer);
    }
}
