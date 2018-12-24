package main.persistence.dao.impl.enums;
public enum StatusSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    StatusSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
