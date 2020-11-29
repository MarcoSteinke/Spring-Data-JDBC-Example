package de.hhu.propra.webserver.services;

import de.hhu.propra.webserver.model.User;
import de.hhu.propra.webserver.persistence.FakeDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    FakeDatabase fakeDatabase;

    @Autowired
    public UserService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public boolean registerUser(String username, String password) {

        User user = User.create(username, password);

        return user.isValid() && this.fakeDatabase.save(user);
    }

    public User loadUser(String username) {
        return this.fakeDatabase.load(username);
    }
}
