package main.persistence.entity.enums;

public enum CardDefaultValuesList {
    CARD_DEFAULT_NAME_CREDIT("Your credit card"),
    CARD_DEFAULT_NAME_DEPOSIT("Your deposit card"),
    CARD_DEFAULT_BALANCE(0.0),
    CARD_DEFAULT_CREDIT_LIMIT(0.0),
    CARD_DEFAULT_SUM_OF_CREDIT(0.0),
    CARD_DEFAULT_PERCENT_VALUE_CREDIT(35.0),
    CARD_DEFAULT_PERCENT_VALUE_DEPOSIT(20.0);

    public Double value;
    public String name;

    CardDefaultValuesList(Double value) {
        this.value = value;
    }

    CardDefaultValuesList(String name) {
        this.name = name;
    }
}