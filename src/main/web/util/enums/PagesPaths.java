package main.web.util.enums;

public enum PagesPaths {
    SITE_PREFIX (""),
    USER_PREFIX (""),
    ADMIN_PREFIX (""),

    HOME_PATH ("index"),
    LOGIN_PATH ("/login"),
    SIGNUP_PATH ("/registration"),
    LOGOUT_PATH ("/logout");

    public String value;

    PagesPaths(String value) {
        this.value = value;
    }
}