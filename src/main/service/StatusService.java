package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.StatusDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.Status;
import java.util.List;

public class StatusService{
    private static final Logger LOGGER = Logger.getLogger(StatusService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static StatusService INSTANCE = new StatusService();
    }

    public static StatusService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createStatus(Status status){
        try(DaoConnection connection = daoFactory.getConnection()) {
            StatusDAO statusDAO = daoFactory.getStatusDAO(connection);
            statusDAO.create(status);
            LOGGER.info("createStatus()");
        }
    }

    public void updateStatus(Status status){
        try(DaoConnection connection = daoFactory.getConnection()) {
            StatusDAO statusDAO = daoFactory.getStatusDAO(connection);
            statusDAO.update(status);
            LOGGER.info("updateStatus()");
        }
    }

    public void deleteStatus(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            StatusDAO statusDAO = daoFactory.getStatusDAO(connection);
            statusDAO.delete(id);
            LOGGER.info("deleteStatus() - " + id);
        }
    }

    public Status findStatusById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            StatusDAO statusDAO = daoFactory.getStatusDAO(connection);
            LOGGER.info("findStatusById() - " + id);
            return statusDAO.findById(id);
        }
    }

    public List<Status> findAllStatus(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            StatusDAO statusDAO = daoFactory.getStatusDAO(connection);
            LOGGER.info("findAllStatus()");
            return statusDAO.findAll();
        }
    }
}
