package main.persistence.dao.impl.enums;
public enum CardTypeSQL {
    SELECT_BY_ID("SELECT * FROM card_type where id = ?"),
    SELECT_ALL("SELECT * FROM card_type"),
    INSERT("INSERT INTO card_type (type) values (?)"),
    DELETE("DELETE FROM card_type where id = ?"),
    UPDATE("UPDATE card_type SET type = ? WHERE id = ?");

    public String QUERY;
    CardTypeSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
