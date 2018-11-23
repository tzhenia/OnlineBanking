package main.persistence.entity.enums;

public enum UserRoleList {
    USER_ROLE_ADMIN(1L, "admin"),
    USER_ROLE_CLIENT(2L, "client");

    public Long id;
    public String role;

    UserRoleList(Long id, String role) {
        this.id = id;
        this.role = role;
    }
}