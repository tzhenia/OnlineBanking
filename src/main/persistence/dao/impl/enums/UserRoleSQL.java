package main.persistence.dao.impl.enums;
public enum UserRoleSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    public String QUERY;
    UserRoleSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
