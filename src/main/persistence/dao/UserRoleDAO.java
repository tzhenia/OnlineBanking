package main.persistence.dao;

import main.persistence.entity.UserRole;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserRoleDAO {
    void create(UserRole userRole);
    void update(UserRole userRole);
    void delete(Long id);
    UserRole findById(Long id);
    List<UserRole> findAll();
    UserRole setValuesForUserRole(ResultSet rs, UserRole userRole) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, UserRole userRole) throws SQLException;
}
