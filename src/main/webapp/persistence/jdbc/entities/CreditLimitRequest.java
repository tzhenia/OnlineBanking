package main.webapp.persistence.jdbc.entities;

import java.io.Serializable;
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
@Table(name = "credit_limit_request")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "SELECT e FROM credit_limit_request e")})

public class CreditLimitRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_card", referencedColumnName = "id")
    @ManyToOne
    private Card card;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne
    private Status status;


    public CreditLimitRequest() {
    }

    public CreditLimitRequest(Long id, Card card, Double creditLimit, Status status) {
        this.id = id;
        this.card = card;
        this.creditLimit = creditLimit;
        this.status = status;
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
