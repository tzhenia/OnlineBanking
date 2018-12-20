package main.persistence.dao;

import main.persistence.entities.Transfer;
import java.util.List;

public interface TransferDAO {
    void create(Transfer transfer);
    void update(Transfer transfer);
    void delete(Long id);
    Transfer findById(Long id);
    List<Transfer> findAll();
}
