package main.persistence.dao.impl.enums;
public enum TransferSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    TransferSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
