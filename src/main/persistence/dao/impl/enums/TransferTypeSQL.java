package main.persistence.dao.impl.enums;
public enum TransferTypeSQL {
    SELECT_BY_ID("SELECT * FROM transfer_type where id = ?"),
    SELECT_ALL("SELECT * FROM transfer_type"),
    INSERT("INSERT INTO transfer_type (type) values (?)"),
    DELETE("DELETE FROM transfer_type where id = ?"),
    UPDATE("UPDATE transfer_type SET type = ? WHERE id = ?");

    public String QUERY;
    TransferTypeSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
