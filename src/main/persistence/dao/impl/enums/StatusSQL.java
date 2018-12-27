package main.persistence.dao.impl.enums;
public enum StatusSQL {
    SELECT_BY_ID("SELECT * FROM status where id = ?"),
    SELECT_ALL("SELECT * FROM status"),
    INSERT("INSERT INTO status (status) values (?)"),
    DELETE("DELETE FROM status where id = ?"),
    UPDATE("UPDATE status SET status = ? WHERE id = ?");

    public String QUERY;
    StatusSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}