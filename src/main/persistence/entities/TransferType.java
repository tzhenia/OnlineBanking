package main.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

public class TransferType implements Serializable {
    private Long id;
    private String cardType;

    public TransferType() {
    }

    public TransferType(Long id, String cardType) {
        this.id = id;
        this.cardType = cardType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "TransferType{" +
                "id=" + id +
                ", cardType=" + cardType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferType that = (TransferType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cardType, that.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType);
    }
}
