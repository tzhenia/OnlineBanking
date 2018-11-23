package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.UserRoleDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.UserRole;
import java.util.List;

public class UserRoleService {
    private static final Logger LOGGER = Logger.getLogger(UserRoleService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static UserRoleService INSTANCE = new UserRoleService();
    }

    public static UserRoleService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createUserRole(UserRole userRole){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserRoleDAO userRoleDAO = daoFactory.getUserRoleDAO(connection);
            userRoleDAO.create(userRole);
            LOGGER.info("createUserRole()");
        }
    }

    public void updateUserRole(UserRole userRole){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserRoleDAO userRoleDAO = daoFactory.getUserRoleDAO(connection);
            userRoleDAO.update(userRole);
            LOGGER.info("updateUserRole()");
        }
    }

    public void deleteUserRole(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserRoleDAO userRoleDAO = daoFactory.getUserRoleDAO(connection);
            userRoleDAO.delete(id);
            LOGGER.info("deleteUserRole() - " + id);
        }
    }

    public UserRole findUserRoleById(Long id){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserRoleDAO userRoleDAO = daoFactory.getUserRoleDAO(connection);
            LOGGER.info("findUserRoleById() - " + id);
            return userRoleDAO.findById(id);
        }
    }

    public List<UserRole> findAllUserRole(){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserRoleDAO userRoleDAO = daoFactory.getUserRoleDAO(connection);
            LOGGER.info("findAllUserRole()");
            return userRoleDAO.findAll();
        }
    }
}
