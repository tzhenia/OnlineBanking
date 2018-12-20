package main.persistence.dao;

import main.persistence.entities.CreditLimitRequest;
import java.util.List;

public interface CreditLimitRequestDAO {
    void create(CreditLimitRequest creditLimitRequest);
    void update(CreditLimitRequest creditLimitRequest);
    void delete(Long id);
    CreditLimitRequest findById(Long id);
    List<CreditLimitRequest> findAll();
}
