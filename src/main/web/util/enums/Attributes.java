package main.web.util.enums;

public enum Attributes {
    USER ("user"),
    ADMIN ("admin"),

    ERRORS ("errors"),
    MESSAGES ("messages"),

    ACCOUNTS ("accounts"),
    CARDS ("cards"),
    PAYMENTS ("payments");

    public String value;

    Attributes(String value) {
        this.value = value;
    }
}