package main.persistence.entity.enums;

public enum CardTypeList {
    CARD_TYPE_CREDIT(1L, "Credit card"),
    CARD_TYPE_DEPOSIT(2L, "Deposit card");

    public Long id;
    public String status;

    CardTypeList(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}