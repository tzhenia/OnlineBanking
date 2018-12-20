package main.persistence.dao.impl;

import main.persistence.dao.UserRoleDAO;
import main.persistence.entities.UserRole;
import java.sql.Connection;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO{
    private final Connection connection;

    public UserRoleDAOImpl(final Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(UserRole userRole) {

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
}