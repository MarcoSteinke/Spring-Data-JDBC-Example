package de.hhu.propra.webserver.services;

import de.hhu.propra.webserver.model.User;
import de.hhu.propra.webserver.model.repositoryabstraction.IUserRepository;
import de.hhu.propra.webserver.persistence.FakeDatabase;
import de.hhu.propra.webserver.persistence.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepositoryImpl userRepository;

    public UserService(UserRepositoryImpl iUserRepository) {
        this.userRepository = iUserRepository;
    }

    public boolean registerUser(String username, String password) {

        User user = User.create(username, password);

        if(user.isValid()) {
            this.userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public User loadUser(String username) {
        return this.userRepository.findUserByUsername(username);
    }
}
