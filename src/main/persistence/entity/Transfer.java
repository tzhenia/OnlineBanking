package main.persistence.entity;

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

    public static class Builder {
        private final Transfer transfer;

        public Builder() {
            transfer = new Transfer();
        }

        public Builder setId(Long id) {
            transfer.setId(id);
            return this;
        }

        public Builder setCardFrom(Card cardFrom) {
            transfer.setCardFrom(cardFrom);
            return this;
        }

        public Builder setCardTo(Card cardTo) {
            transfer.setCardTo(cardTo);
            return this;
        }

        public Builder setSum(Double sum) {
            transfer.setSum(sum);
            return this;
        }

        public Builder setNote(String note) {
            transfer.setNote(note);
            return this;
        }

        public Builder setTransferType(TransferType transferType) {
            transfer.setTransferType(transferType);
            return this;
        }

        public Builder setStatus(Status status) {
            transfer.setStatus(status);
            return this;
        }

        public Builder setDate(Date date) {
            transfer.setDate(date);
            return this;
        }

        public Transfer build() {
            return transfer;
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
