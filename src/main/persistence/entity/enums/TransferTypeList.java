package main.persistence.entity.enums;

public enum TransferTypeList {
    TRANSFER_TYPE_TRANSFER(1L, "Transfer"),
    TRANSFER_TYPE_INVOICE(2L, "Invoice");

    public Long id;
    public String role;

    TransferTypeList(Long id, String role) {
        this.id = id;
        this.role = role;
    }
}