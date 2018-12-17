package main.webapp.persistence.jdbc.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "transfer_type")
@NamedQueries({@NamedQuery(name = "Users.findAll", query = "SELECT e FROM transfer_type e")})

public class TransferType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String cardType;


    public TransferType() {
    }

    public TransferType(Long id, String cardType) {
        this.id = id;
        this.cardType = cardType;
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

    public String getTransferType() {
        return cardType;
    }

    public void setTransferType(String cardType) {
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
