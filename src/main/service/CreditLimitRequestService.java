package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.CreditLimitRequestDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.CreditLimitRequest;
import java.util.List;

public class CreditLimitRequestService {
    private static final Logger LOGGER = Logger.getLogger(CreditLimitRequestService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static CreditLimitRequestService INSTANCE = new CreditLimitRequestService();
    }

    public static CreditLimitRequestService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createCreditLimitRequest(CreditLimitRequest creditLimitRequest){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CreditLimitRequestDAO creditLimitRequestDAO = daoFactory.getCreditLimitRequestDAO(connection);
            creditLimitRequestDAO.create(creditLimitRequest);
            LOGGER.info("createCreditLimitRequest()");
        }
    }

    public void updateCreditLimitRequest(CreditLimitRequest creditLimitRequest){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CreditLimitRequestDAO creditLimitRequestDAO = daoFactory.getCreditLimitRequestDAO(connection);
            creditLimitRequestDAO.update(creditLimitRequest);
            LOGGER.info("updateCreditLimitRequest()");
        }
    }

    public void deleteCreditLimitRequest(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CreditLimitRequestDAO creditLimitRequestDAO = daoFactory.getCreditLimitRequestDAO(connection);
            creditLimitRequestDAO.delete(id);
            LOGGER.info("deleteCreditLimitRequest() - " + id);
        }
    }

    public CreditLimitRequest findCreditLimitRequestById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CreditLimitRequestDAO creditLimitRequestDAO = daoFactory.getCreditLimitRequestDAO(connection);
            LOGGER.info("findCreditLimitRequestById() - " + id);
            return creditLimitRequestDAO.findById(id);
        }
    }

    public List<CreditLimitRequest> findAllCreditLimitRequest(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            CreditLimitRequestDAO creditLimitRequestDAO = daoFactory.getCreditLimitRequestDAO(connection);
            LOGGER.info("findAllCreditLimitRequest()");
            return creditLimitRequestDAO.findAll();
        }
    }
}
