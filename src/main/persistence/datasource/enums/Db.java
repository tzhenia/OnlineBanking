package main.persistence.datasource.enums;

public enum Db {

    BUNDLE("database"),
    URL("url"),
    DRIVER("driver"),
    USER("user"),
    PASSWORD("password");

    public String value;

    Db(String value) {
        this.value = value;
    }
}