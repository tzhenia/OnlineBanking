package main.web.util.enums;

public enum Views {
    FOLDER ( "/views/"),

    HOME_VIEW (FOLDER + "index.jsp"),
    LOGIN_VIEW (FOLDER + "login.jsp"),
    SIGNUP_VIEW (FOLDER + "signup.jsp"),
    ACCOUNTS_VIEW (FOLDER + "accounts.jsp"),
    CARDS_VIEW (FOLDER + "cards.jsp"),
    PAYMENTS_VIEW (FOLDER + "payments.jsp"),
    NEW_PAYMENT_VIEW (FOLDER + "createPayment.jsp"),
    REPLENISH_VIEW (FOLDER + "replenish.jsp");

    public String value;

    Views(String value) {
        this.value = value;
    }
}