package main.persistence;

import main.persistence.connection.DBDriverBase;
import main.persistence.connection.DBTypes;
import main.persistence.connection.DBDriverFactory;
import main.persistence.connection.Database;
import main.persistence.entities.User;
import main.persistence.dao.impl.UserDAOImpl;
import main.persistence.entities.UserRole;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        DBDriverBase dbDriver = DBDriverFactory.createDriver(DBTypes.MYSQL);
        Database jdbcConn = new Database(dbDriver, "jdbc:mysql://localhost:3306/onlineBanking", "rootroot", "root");
        jdbcConn.connect();
        UserDAOImpl userDAOImpl = new UserDAOImpl(jdbcConn.getConnection());

        if (jdbcConn.validate()) {
            // createUser(jdbcConn, userDAOImpl);
         //   update(jdbcConn, userDAOImpl, 8L);
         // findById(jdbcConn, userDAOImpl, 5L);
         // findALL(jdbcConn, userDAOImpl);
         // delete(jdbcConn, userDAOImpl, 6L);
        }

        else {
            System.out.println("Database connection error. See log file for more info.");
        }
    }

    // TEST DAO
    private static void createUser (Database jdbcConn, UserDAOImpl userDAOImpl) throws Exception{
        String date = "1993-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        UserRole role = new UserRole (2L,"TEST");
        User user = new User(99L, "tzhenia111112233", 111, "111", "Женя2", "Женя", "Женя 3", dateDB, role);
        userDAOImpl.create(user);
    }

    private static void update (Database jdbcConn, UserDAOImpl userDAOImpl, Long id) throws Exception{
        String date = "1293-03-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        UserRole role = new UserRole (2L,"TEST");
        User user = new User(999L, "new_tzhenia11111223300000", 1000, "new_3399990", "new_Женя2", "new_Женя", "new_Женя 3", dateDB, role);
        userDAOImpl.update(id, user);
    }

    private static void findById (Database jdbcConn, UserDAOImpl userDAOImpl, Long id) throws Exception{
        User user = userDAOImpl.findById(id);
        System.out.println(user.toString());
    }

    private static void findALL (Database jdbcConn, UserDAOImpl userDAOImpl) throws Exception{
        List<User> users = userDAOImpl.findAll();
        for (User item : users){
            System.out.println(item.toString());
        }
    }

    private static void delete(Database jdbcConn, UserDAOImpl userDAOImpl, Long id) throws Exception{
      userDAOImpl.delete(id);
    }
}