package main.persistence.dao;

import main.persistence.entities.TransferType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TransferTypeDAO {
    void create(TransferType transferType);
    void update(TransferType transferType);
    void delete(Long id);
    TransferType findById(Long id);
    List<TransferType> findAll();
    TransferType setValuesForUser(ResultSet rs, TransferType transferType) throws SQLException;
    PreparedStatement setValuesForStatement(PreparedStatement statement, TransferType transferType) throws SQLException;
}
