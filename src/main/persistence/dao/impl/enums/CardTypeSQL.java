package main.persistence.dao.impl.enums;
public enum CardTypeSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    CardTypeSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
