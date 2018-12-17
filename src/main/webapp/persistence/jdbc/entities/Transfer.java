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
@Table(name = "transfer")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "SELECT e FROM transfer e")})

public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_card_from", referencedColumnName = "id")
    @ManyToOne
    private Card card_from;

    @JoinColumn(name = "id_card_to", referencedColumnName = "id")
    @ManyToOne
    private Card card_to;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "note")
    private String note;

    @JoinColumn(name = "id_transfer_type", referencedColumnName = "id")
    @ManyToOne
    private TransferType transferType;

    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne
    private Status status;

    @Column(name = "time")
    private Date date;

    public Transfer() {
    }

    public Transfer(Long id, Card card_from, Card card_to, Double sum, String note, TransferType transferType, Status status, Date date) {
        this.id = id;
        this.card_from = card_from;
        this.card_to = card_to;
        this.sum = sum;
        this.note = note;
        this.transferType = transferType;
        this.status = status;
        this.date = date;
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

    public Card getCard_from() {
        return card_from;
    }

    public void setCard_from(Card card_from) {
        this.card_from = card_from;
    }

    public Card getCard_to() {
        return card_to;
    }

    public void setCard_to(Card card_to) {
        this.card_to = card_to;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", card_from=" + card_from +
                ", card_to=" + card_to +
                ", sum=" + sum +
                ", note='" + note + '\'' +
                ", transferType=" + transferType +
                ", status=" + status +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) &&
                Objects.equals(card_from, transfer.card_from) &&
                Objects.equals(card_to, transfer.card_to) &&
                Objects.equals(sum, transfer.sum) &&
                Objects.equals(note, transfer.note) &&
                Objects.equals(transferType, transfer.transferType) &&
                Objects.equals(status, transfer.status) &&
                Objects.equals(date, transfer.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card_from, card_to, sum, note, transferType, status, date);
    }
}
