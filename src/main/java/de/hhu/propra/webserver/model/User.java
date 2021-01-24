package de.hhu.propra.webserver.model;

import de.hhu.propra.webserver.services.PasswordService;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class User {

    private final String username;
    private final String password;
    private final String salt;

    private User(String username, String password) {
        this.username = username;
        this.salt = "" + Math.pow(LocalDateTime.now().getNano(), password.length());
        this.password = PasswordService.hash(password, salt);
    }

    // Constructor for mapper only
    public User(String username, String password, String salt) {
        this.username = username;
        this.salt = salt;
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
