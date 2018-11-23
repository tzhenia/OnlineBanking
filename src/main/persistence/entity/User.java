package main.persistence.entity;

import main.persistence.entity.enums.UserRoleList;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String email;
    private Integer phone;
    private String password;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Date birthday;
    private UserRole userRole;

    public static class Builder{
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder setId(Long id) {
            user.setId(id);
            return this;
        }

        public Builder setEmail(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder setPhone(int phone) {
            user.setPhone(phone);
            return this;
        }

        public Builder setPassword(String setPassword) {
            user.setPassword(setPassword);
            return this;
        }

        public Builder setFirstName(String firstName) {
            user.setFirstName(firstName);
            return this;
        }

        public Builder setLastName(String lastName) {
            user.setLastName(lastName);
            return this;
        }

        public Builder setFatherName(String fatherName) {
            user.setFatherName(fatherName);
            return this;
        }

        public Builder setBirthday(Date birthday) {
            user.setBirthday(birthday);
            return this;
        }

        public Builder setRole(UserRole userRole) {
            user.setUserRole(userRole);
            return this;
        }

        public User build() {
            return user;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setDefaultRole() {
        this.userRole = new UserRole(UserRoleList.USER_ROLE_CLIENT.id, UserRoleList.USER_ROLE_CLIENT.role);
    }

    public boolean isAdmin() {
        return userRole.getId().equals(UserRoleList.USER_ROLE_CLIENT.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthday=" + birthday +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phone == user.phone &&
                Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(fatherName, user.fatherName) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone, password, firstName, lastName, fatherName, birthday, userRole);
    }
}
