package main.persistence.dao.impl.enums;
public enum UserRoleSQL {
    SELECT_BY_ID("SELECT * FROM user_role where id = ?"),
    SELECT_ALL("SELECT * FROM user_role"),
    INSERT("INSERT INTO user_role (role) values (?)"),
    DELETE("DELETE FROM user_role where id = ?"),
    UPDATE("UPDATE user_role SET role = ? WHERE id = ?");

    public String QUERY;
    UserRoleSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
