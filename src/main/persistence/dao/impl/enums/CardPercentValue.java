package main.persistence.dao.impl.enums;
public enum CardPercentValue {
    DEPOSIT_STANDART(20d),
    CREDIT_STANDART(35d);

    public Double PERCENT_VALUE;
    CardPercentValue(Double PERCENT_VALUE) {
        this.PERCENT_VALUE = PERCENT_VALUE;
    }
}