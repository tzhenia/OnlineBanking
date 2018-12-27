package main.persistence.dao;

import main.persistence.entities.CreditLimitRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CreditLimitRequestDAO {
    void create(CreditLimitRequest creditLimitRequest);
    void update(Long id, CreditLimitRequest creditLimitRequest);
    void delete(Long id);
    CreditLimitRequest findById(Long id);
    List<CreditLimitRequest> findAll();
    CreditLimitRequest setValuesForCreditLimitRequest(ResultSet rs, CreditLimitRequest creditLimitRequest) throws SQLException ;
    PreparedStatement setValuesForStatement(PreparedStatement statement, CreditLimitRequest creditLimitRequest) throws SQLException;
}
