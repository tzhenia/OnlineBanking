package main.persistence.dao.impl;

import main.persistence.dao.StatusDAO;
import main.persistence.dao.impl.enums.StatusSQL;
import main.persistence.entities.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAOImpl implements StatusDAO {
    private final Connection connection;

    public StatusDAOImpl(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Status status) {
        try (PreparedStatement statement = connection.prepareStatement(StatusSQL.INSERT.QUERY)) {
            setValuesForStatement(statement, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Status status) {
        try (PreparedStatement statement = connection.prepareStatement(StatusSQL.UPDATE.QUERY)) {
            setValuesForStatement(statement, status);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id){
        try (PreparedStatement statement = connection.prepareStatement(StatusSQL.DELETE.QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Status findById(Long id) {
        Status status = new Status();

        try (PreparedStatement statement = connection.prepareStatement(StatusSQL.SELECT_BY_ID.QUERY)) {
            statement.setLong(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                setValuesForStatus(rs, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Status> findAll() {
        List<Status> statuses = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(StatusSQL.SELECT_ALL.QUERY)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                setValuesForStatus(rs, status);
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public Status setValuesForStatus(ResultSet rs, Status status) throws SQLException {
        status.setId(rs.getLong("id"));
        status.setStatus(rs.getString("status"));
        return status;
    }

    @Override
    public PreparedStatement setValuesForStatement(PreparedStatement statement, Status status) throws SQLException {
        statement.setString(1, status.getStatus());
        return statement;
    }
}
