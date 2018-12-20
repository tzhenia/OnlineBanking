package main.persistence.dao;

import main.persistence.entities.User;
import java.util.List;

public interface UserDAO{
    void create(User user);
    void update(Long id, User user);
    void delete(Long id);
    User findById(Long id);
    List<User> findAll();
}