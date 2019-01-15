package main.persistence.factory.connection.enums;

public enum Error {

    DURING_START("Failed to start transaction"),
    DURING_COMMIT("Failed to commit transaction"),
    DURING_ROLLBACK("Failed to rollback transaction"),
    DURING_CLOSE("Failed to close transaction"),
    NULLABLE_CONNECTION("Failed to close transaction"),
    WRONG_TYPE_CONNECTION("Failed to close transaction");

    public String value;

    Error(String value) {
        this.value = value;
    }
}