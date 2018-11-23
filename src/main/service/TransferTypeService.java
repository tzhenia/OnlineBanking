package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.TransferTypeDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.TransferType;
import java.util.List;

public class TransferTypeService {
    private static final Logger LOGGER = Logger.getLogger(TransferTypeService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static TransferTypeService INSTANCE = new TransferTypeService();
    }

    public static TransferTypeService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createTransferType(TransferType transferType){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferTypeDAO transferTypeDAO = daoFactory.getTransferTypeDAO(connection);
            transferTypeDAO.create(transferType);
            LOGGER.info("createTransferType()");
        }
    }

    public void updateTransferType(TransferType transferType){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferTypeDAO transferTypeDAO = daoFactory.getTransferTypeDAO(connection);
            transferTypeDAO.update(transferType);
            LOGGER.info("updateTransferType()");
        }
    }

    public void deleteTransferType(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferTypeDAO transferTypeDAO = daoFactory.getTransferTypeDAO(connection);
            transferTypeDAO.delete(id);
            LOGGER.info("deleteTransferType() - " + id);
        }
    }

    public TransferType findTransferTypeById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferTypeDAO transferTypeDAO = daoFactory.getTransferTypeDAO(connection);
            LOGGER.info("findTransferTypeById() - " + id);
            return transferTypeDAO.findById(id);
        }
    }

    public List<TransferType> findAllTransferType(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            TransferTypeDAO transferTypeDAO = daoFactory.getTransferTypeDAO(connection);
            LOGGER.info("findAllTransferType()");
            return transferTypeDAO.findAll();
        }
    }
}
