package main.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Transfer implements Serializable {
    private Long id;
    private Card cardFrom;
    private Card cardTo;
    private Double sum;
    private String note;
    private TransferType transferType;
    private Status status;
    private Date date;

    public Transfer() {
    }

    public Transfer(Long id, Card cardFrom, Card cardTo, Double sum, String note, TransferType transferType, Status status, Date date) {
        this.id = id;
        this.cardFrom = cardFrom;
        this.cardTo = cardTo;
        this.sum = sum;
        this.note = note;
        this.transferType = transferType;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Card cardFrom) {
        this.cardFrom = cardFrom;
    }

    public Card getCardTo() {
        return cardTo;
    }

    public void setCardTo(Card cardTo) {
        this.cardTo = cardTo;
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
                ", cardFrom=" + cardFrom +
                ", cardTo=" + cardTo +
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
                Objects.equals(cardFrom, transfer.cardFrom) &&
                Objects.equals(cardTo, transfer.cardTo) &&
                Objects.equals(sum, transfer.sum) &&
                Objects.equals(note, transfer.note) &&
                Objects.equals(transferType, transfer.transferType) &&
                Objects.equals(status, transfer.status) &&
                Objects.equals(date, transfer.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardFrom, cardTo, sum, note, transferType, status, date);
    }
}
