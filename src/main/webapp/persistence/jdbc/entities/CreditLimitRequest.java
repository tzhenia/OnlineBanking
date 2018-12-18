package main.webapp.persistence.jdbc.entities;

import java.io.Serializable;
import java.util.Objects;

public class CreditLimitRequest implements Serializable {
    private Long id;
    private Card card;
    private Double creditLimit;
    private Status status;


    public CreditLimitRequest() {
    }

    public CreditLimitRequest(Long id, Card card, Double creditLimit, Status status) {
        this.id = id;
        this.card = card;
        this.creditLimit = creditLimit;
        this.status = status;
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
