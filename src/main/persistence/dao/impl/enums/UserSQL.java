package main.persistence.dao.impl.enums;
public enum UserSQL {
    SELECT_BY_ID("SELECT u.id, u.email, u.phone, u.password, u.first_name, u.last_name, u.father_name, u.birthday, u.id_user_role, r.role FROM user u INNER JOIN user_role r ON u.id_user_role = r.id WHERE u.id = ?"),
    SELECT_BY_EMAIL("SELECT u.id, u.email, u.phone, u.password, u.first_name, u.last_name, u.father_name, u.birthday, u.id_user_role, r.role FROM user u INNER JOIN user_role r ON u.id_user_role = r.id WHERE u.email = ?"),
    SELECT_ALL("SELECT u.id, u.email, u.phone, u.password, u.first_name, u.last_name, u.father_name, u.birthday, u.id_user_role, r.role FROM user u INNER JOIN user_role r ON u.id_user_role = r.id"),
    INSERT("INSERT INTO user (email, phone, password, first_name, last_name, father_name, birthday, id_user_role) values (?,?,?,?,?,?,?,?)"),
    DELETE("DELETE FROM user where id = ?"),
    UPDATE("UPDATE user SET email = ?, phone = ?, password = ?, first_name = ?, last_name = ?, father_name = ?, birthday = ? WHERE id = ?");

    public String QUERY;
    UserSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}