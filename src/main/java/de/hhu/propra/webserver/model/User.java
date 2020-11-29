package de.hhu.propra.webserver.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private final String username;
    private final String password;

    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return this.username != "error";
    }

    public static User create(String username, String password) {
        if(username == null || password == null || username.length() < 6 || password.length() < 8) {
            return new User("error", null);
        } else {
            return new User(username, password);
        }
    }
}
