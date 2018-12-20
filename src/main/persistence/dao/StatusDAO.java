package main.persistence.dao;

import main.persistence.entities.Status;
import java.util.List;

public interface StatusDAO {
    void create(Status status);
    void update(Status status);
    void delete(Long id);
    Status findById(Long id);
    List<Status> findAll();
}
