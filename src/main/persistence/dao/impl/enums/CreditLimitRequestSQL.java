package main.persistence.dao.impl.enums;
public enum CreditLimitRequestSQL {
    SELECT_BY_ID("SELECT  c.id, c.id_card, c.credit_limit, s.id, s.status FROM credit_limit_request c INNER JOIN status s ON c.id_status = s.id WHERE c.id = ?"),
    SELECT_ALL("SELECT  c.id, c.id_card, c.credit_limit, s.id, s.status FROM credit_limit_request c INNER JOIN status s ON c.id_status = s.id"),
    INSERT("INSERT INTO credit_limit_request (id_card, credit_limit, id_status) values (?,?,?)"),
    DELETE("DELETE FROM credit_limit_request where id = ?"),
    UPDATE("UPDATE credit_limit_request SET id_card = ?, credit_limit = ?, id_status = ? WHERE id = ?");

    public String QUERY;
    CreditLimitRequestSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
