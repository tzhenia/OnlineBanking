package main.persistence.dao.impl.enums;
public enum UserRoleSQL {
    SELECT_BY_ID(""),
    SELECT_ALL(""),
    INSERT("INSERT INTO user_role (role) values (?)"),
    DELETE("DELETE FROM user_role where id = ?"),
    UPDATE("");

    public String QUERY;
    UserRoleSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
