package main.persistence.dao;

import main.persistence.entities.Transfer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TransferDAO {
    void create(Transfer transfer);
    void update(Transfer transfer);
    void delete(Long id);
    Transfer findById(Long id);
    List<Transfer> findAll();
    Transfer setValuesForTransfer(ResultSet rs, Transfer transfer) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, Transfer transfer) throws SQLException;
}
