package de.hhu.propra.webserver.persistence;

import de.hhu.propra.webserver.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeDatabase {

    List<User> users;

    private FakeDatabase() {
        this.users = new ArrayList<User>();
    }

    public FakeDatabase create() {
        return new FakeDatabase();
    }

    public boolean save(User user) {
        for(User savedUser : users) {
            if(user.getUsername().equals(savedUser.getUsername())) {
                return false;
            }
        }
        boolean result = users.add(user);

        users.stream().forEach(System.out::println);

        return result;
    }

    public User load(String username) {
        for(User savedUser : users) {
            if(username.equals(savedUser.getUsername())) {
                return savedUser;
            }

        }

        return User.create("error", null);
    }
}
