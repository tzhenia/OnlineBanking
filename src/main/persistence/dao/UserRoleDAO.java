package main.persistence.dao;

import main.persistence.entities.UserRole;
import java.util.List;

public interface UserRoleDAO {
    void create(UserRole userRole);
    void update(Long id, UserRole userRole);
    void delete(Long id);
    UserRole findById(Long id);
    List<UserRole> findAll();
}
