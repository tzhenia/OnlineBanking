package main.service;

import org.apache.log4j.Logger;
import main.persistence.dao.UserDAO;
import main.persistence.factory.DaoFactory;
import main.persistence.factory.connection.DaoConnection;
import main.persistence.entity.User;
import java.util.List;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Singleton {
        private final static UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return Singleton.INSTANCE;
    }

    public void createUser(User user){
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            userDAO.create(user);
            LOGGER.info("createUser()");
        }
    }

    public void updateUser(User user)  {
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            userDAO.update(user);
            LOGGER.info("updateUser()");
        }
    }

    public void deleteUser(Long id) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            userDAO.delete(id);
            LOGGER.info("deleteUser() - " + id);
        }
    }

    public User findUserById(Long id) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            LOGGER.info("findUserById() - " + id);
            return userDAO.findById(id);
        }
    }

    public User findUserByEmail(String email) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            LOGGER.info("findUserByEmail() - " + email);
            return userDAO.findByEmail(email);
        }
    }

    public List<User> findAllUser() {
        try(DaoConnection connection = daoFactory.getConnection()) {
            UserDAO userDAO = daoFactory.getUserDAO(connection);
            LOGGER.info("findAllUser()");
            return userDAO.findAll();
        }
    }
}
