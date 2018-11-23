package main.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

public class CreditLimitRequest implements Serializable {
    private Long id;
    private Card card;
    private Double creditLimit;
    private Status status;

    public static class Builder{
        private final CreditLimitRequest creditLimitRequest;

        public Builder() {
            creditLimitRequest = new CreditLimitRequest();
        }

        public Builder setId(Long id) {
            creditLimitRequest.setId(id);
            return this;
        }

        public Builder setCard(Card card) {
            creditLimitRequest.setCard(card);
            return this;
        }

        public Builder setPassword(Double creditLimit) {
            creditLimitRequest.setCreditLimit(creditLimit);
            return this;
        }

        public Builder setStatus(Status status) {
            creditLimitRequest.setStatus(status);
            return this;
        }

        public CreditLimitRequest build() {
            return creditLimitRequest;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreditLimitRequest{" +
                "id=" + id +
                ", card=" + card +
                ", creditLimit=" + creditLimit +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditLimitRequest that = (CreditLimitRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(card, that.card) &&
                Objects.equals(creditLimit, that.creditLimit) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, creditLimit, status);
    }
}
