package main.web.util.enums;

public enum PagesPaths {
    SITE_PREFIX ("/site"),
    USER_PREFIX ("/user"),
    ADMIN_PREFIX ("/admin"),

    HOME_PATH ("index"),
    LOGIN_PATH ("/login"),
    SIGNUP_PATH ("/registration"),
    LOGOUT_PATH ("/logout");

    public String value;

    PagesPaths(String value) {
        this.value = value;
    }
}