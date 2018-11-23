package main.persistence.entity.enums;

public enum StatusList {
    STATUS_WAITING(1L, "Waiting"),
    STATUS_TRANSFERRED(2L, "Transferred"),
    STATUS_ARCHIVE(3L, "Archive"),
    STATUS_APPROVED(4L, "Approved");

    public Long id;
    public String status;

    StatusList(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}

