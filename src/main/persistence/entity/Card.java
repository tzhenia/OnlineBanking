package main.persistence.entity;

import main.persistence.entity.enums.CardDefaultValuesList;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Card implements Serializable {
    private Long id;
    private User user;
    private Integer number;
    private CardType cardType;
    private String cardName;
    private Double balance;
    private Double creditLimit;
    private Date expiryDate;
    private Double sumOfCredit;
    private Double percentValue;

    public static class Builder{
        private final Card card;

        public Builder() {
            card = new Card();
        }

        public Builder setId(Long id) {
            card.setId(id);
            return this;
        }

        public Builder setUser(User user) {
            card.setUser(user);
            return this;
        }

        public Builder setNumber(Integer number) {
            card.setNumber(number);
            return this;
        }

        public Builder setCardType(CardType cardType) {
            card.setCardType(cardType);
            return this;
        }

        public Builder setCardName(String cardName) {
            card.setCardName(cardName);
            return this;
        }

        public Builder setBalance(Double balance) {
            card.setBalance(balance);
            return this;
        }

        public Builder setCreditLimit(Double creditLimit) {
            card.setCreditLimit(creditLimit);
            return this;
        }

        public Builder setExpiryDate(Date expiryDate) {
            card.setExpiryDate(expiryDate);
            return this;
        }

        public Builder setSumOfCredit(Double sumOfCredit) {
            card.setSumOfCredit(sumOfCredit);
            return this;
        }

        public Builder setPercentValue(Double percentValue) {
            card.setPercentValue(percentValue);
            return this;
        }

        public Builder setDefaultValuesForCreditCard() {
            card.setCardName(CardDefaultValuesList.CARD_DEFAULT_NAME_CREDIT.name);
            card.setBalance(CardDefaultValuesList.CARD_DEFAULT_BALANCE.value);
            card.setCreditLimit(CardDefaultValuesList.CARD_DEFAULT_CREDIT_LIMIT.value);
            card.setSumOfCredit(CardDefaultValuesList.CARD_DEFAULT_SUM_OF_CREDIT.value);
            card.setPercentValue(CardDefaultValuesList.CARD_DEFAULT_PERCENT_VALUE_CREDIT.value);
            return this;
        }

        public Builder setDefaultValuesForDepositCard() {
            card.setCardName(CardDefaultValuesList.CARD_DEFAULT_NAME_DEPOSIT.name);
            card.setBalance(CardDefaultValuesList.CARD_DEFAULT_BALANCE.value);
            card.setCreditLimit(CardDefaultValuesList.CARD_DEFAULT_CREDIT_LIMIT.value);
            card.setSumOfCredit(CardDefaultValuesList.CARD_DEFAULT_SUM_OF_CREDIT.value);
            card.setPercentValue(CardDefaultValuesList.CARD_DEFAULT_PERCENT_VALUE_DEPOSIT.value);
            return this;
        }

        public Card build() {
            return card;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Double getSumOfCredit() {
        return sumOfCredit;
    }

    public void setSumOfCredit(Double sumOfCredit) {
        this.sumOfCredit = sumOfCredit;
    }

    public Double getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(Double percentValue) {
        this.percentValue = percentValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", user=" + user +
                ", number=" + number +
                ", cardType=" + cardType +
                ", cardName='" + cardName + '\'' +
                ", balance=" + balance +
                ", creditLimit=" + creditLimit +
                ", expiryDate=" + expiryDate +
                ", sumOfCredit=" + sumOfCredit +
                ", percentValue=" + percentValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(user, card.user) &&
                Objects.equals(number, card.number) &&
                Objects.equals(cardType, card.cardType) &&
                Objects.equals(cardName, card.cardName) &&
                Objects.equals(balance, card.balance) &&
                Objects.equals(creditLimit, card.creditLimit) &&
                Objects.equals(expiryDate, card.expiryDate) &&
                Objects.equals(sumOfCredit, card.sumOfCredit) &&
                Objects.equals(percentValue, card.percentValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, number, cardType, cardName, balance, creditLimit, expiryDate, sumOfCredit, percentValue);
    }
}
