package main.persistence.dao.impl.enums;
public enum CardSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    CardSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
