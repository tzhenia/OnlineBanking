package main.persistence.dao.impl;

import main.persistence.dao.UserRoleDAO;
import main.persistence.dao.impl.enums.UserRoleSQL;
import main.persistence.entities.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try (PreparedStatement statement = connection.prepareStatement(UserRoleSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, userRole);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(UserRoleSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserRole findById(Long id) {
        UserRole userRole = new UserRole();

        try (PreparedStatement statement = connection.prepareStatement(UserRoleSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForUserRole(rs, userRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRole;
    }

    @Override
    public List<UserRole> findAll() {
        List<UserRole> userRoles = new ArrayList<UserRole>();

        try (PreparedStatement statement = connection.prepareStatement(UserRoleSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserRole userRole = new UserRole();
                setValuesForUserRole(rs, userRole);
                userRoles.add(userRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public UserRole setValuesForUserRole(ResultSet rs, UserRole userRole) throws SQLException {
        userRole.setId(rs.getLong("id"));
        userRole.setRole(rs.getString("role"));
        return userRole;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, UserRole userRole) throws SQLException {
       statement.setString(1, userRole.getRole());
        return statement;
    }
}