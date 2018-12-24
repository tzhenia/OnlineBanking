package main.persistence.dao.impl.enums;
public enum CreditLimitRequestSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    CreditLimitRequestSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
