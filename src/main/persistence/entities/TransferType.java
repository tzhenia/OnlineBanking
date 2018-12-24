package main.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

public class TransferType implements Serializable {
    private Long id;
    private String transferType;

    public TransferType() {
    }

    public TransferType(Long id, String transferType) {
        this.id = id;
        this.transferType = transferType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "TransferType{" +
                "id=" + id +
                ", transferType=" + transferType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferType that = (TransferType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transferType, that.transferType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transferType);
    }
}
