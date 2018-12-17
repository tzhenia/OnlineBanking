package main.webapp.persistence.jdbc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "card")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "SELECT e FROM card e")})

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @Column(name = "number")
    private Integer number;

    @JoinColumn(name = "id_card_type", referencedColumnName = "id")
    @ManyToOne
    private CardType cardType;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "sum_of_credit")
    private Double sumOfCredit;

    @Column(name = "percent_value")
    private Double percentValue;

    public Card() {
    }

    public Card(Long id, User user, Integer number, CardType cardType, String cardName, Double balance, Double creditLimit, Date expiryDate, Double sumOfCredit, Double percentValue) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.cardType = cardType;
        this.cardName = cardName;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.expiryDate = expiryDate;
        this.sumOfCredit = sumOfCredit;
        this.percentValue = percentValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
