package main.persistence.dao.impl.enums;
public enum CardSQL {
    SELECT_BY_ID("SELECT card.id, card.id_user, card.number, card.id_card_type, card.card_name, card.balance, card.credit_limit, card.expiry_date, card.sum_of_credit, card.percent_value, type.type FROM card card INNER JOIN card_type type ON card.id_card_type = type.id WHERE card.id = ?"),
    SELECT_ALL("SELECT card.id, card.id_user, card.number, card.id_card_type, card.card_name, card.balance, card.credit_limit, card.expiry_date, card.sum_of_credit, card.percent_value, type.type FROM card card INNER JOIN card_type type ON card.id_card_type = type.id"),
    INSERT("INSERT INTO card (id_user, number, id_card_type, card_name, balance, credit_limit, expiry_date, sum_of_credit, percent_value) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
    DELETE("DELETE FROM card where id = ?"),
    UPDATE("UPDATE card SET id_user = ?, number = ?, id_card_type = ?, card_name = ?, balance = ?, credit_limit = ?, expiry_date = ?, sum_of_credit = ?, percent_value = ? WHERE id = ?");

    public String QUERY;
    CardSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}