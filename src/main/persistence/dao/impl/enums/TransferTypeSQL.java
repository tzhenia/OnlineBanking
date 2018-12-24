package main.persistence.dao.impl.enums;
public enum TransferTypeSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    TransferTypeSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
