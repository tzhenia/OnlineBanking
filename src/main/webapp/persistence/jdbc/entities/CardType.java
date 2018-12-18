package main.webapp.persistence.jdbc.entities;

import java.io.Serializable;
import java.util.Objects;

public class CardType implements Serializable {
    private Long id;
    private String cardType;

    public CardType() {
    }

    public CardType(Long id, String cardType) {
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
        return "CardType{" +
                "id=" + id +
                ", cardType=" + cardType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardType cardType1 = (CardType) o;
        return Objects.equals(id, cardType1.id) &&
                Objects.equals(cardType, cardType1.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType);
    }
}
