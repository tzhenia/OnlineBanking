package main.persistence.dao.impl;

import main.persistence.dao.UserRoleDAO;
import main.persistence.dao.impl.enums.UserRoleSQL;
import main.persistence.entities.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO{
    private final Connection connection;

    public UserRoleDAOImpl(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(UserRole userRole) {
        try (PreparedStatement statement = connection.prepareStatement(UserRoleSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, userRole);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, UserRole userRole) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserRole findById(Long id) {
        return null;
    }

    @Override
    public List<UserRole> findAll() {
        return null;
    }

    @Override
    public UserRole setValuesForUser(ResultSet rs, UserRole userRole) throws SQLException {
        userRole.setId(rs.getLong("id"));
        //userRole.setEmail(rs.getString("email"));

        return userRole;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, UserRole userRole) throws SQLException {
        //statement.setString(1, userRole.getEmail());
       // statement.setInt(2, userRole.getPhone());
        return statement;
    }
}