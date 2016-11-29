package ru.course.selenium.domain;

/**
 * Created by Aleksei.Klimenko on 28.11.2016.
 */
public enum UserEnum {
    ADMIN("admin", "admin");

    private final String username;
    private final String password;

    UserEnum(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
