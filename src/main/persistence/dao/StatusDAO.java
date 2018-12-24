package main.persistence.dao;

import main.persistence.entities.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface StatusDAO {
    void create(Status status);
    void update(Status status);
    void delete(Long id);
    Status findById(Long id);
    List<Status> findAll();
    Status setValuesForStatus(ResultSet rs, Status status) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, Status status) throws SQLException;
}
