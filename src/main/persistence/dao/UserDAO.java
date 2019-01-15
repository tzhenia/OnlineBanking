package main.persistence.dao;

import main.persistence.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO{
    void create(User user);
    void update(User user);
    void delete(Long id);
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    User setValuesForUser(ResultSet rs, User user) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, User user) throws SQLException;
}