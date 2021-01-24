package de.hhu.propra.webserver.persistence.repositories;

import de.hhu.propra.webserver.model.User;
import de.hhu.propra.webserver.model.repositoryabstraction.IUserRepository;
import de.hhu.propra.webserver.persistence.dto.UserDTO;
import de.hhu.propra.webserver.persistence.mappers.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private UserCrudRepository repository;

    public UserRepositoryImpl(UserCrudRepository repository) {
        this.repository = repository;
    }

    // This is a wrapper method to be able to map the UserDTO to a User before returning.
    public User findUserByUsername(String username) {
        return UserMapper.mapToUser(this.repository.findById(username).get());
    }

    // This again is a wrapper method to save users.
    public void save(User user) {
        UserDTO userDTO = UserMapper.mapToUserDTO(user);
        this.repository.save(userDTO);
    }
}
