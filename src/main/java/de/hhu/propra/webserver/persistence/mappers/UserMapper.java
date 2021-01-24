package de.hhu.propra.webserver.persistence.mappers;

import de.hhu.propra.webserver.model.User;
import de.hhu.propra.webserver.persistence.dto.UserDTO;

public class UserMapper {

    public static User mapToUser(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getSalt());
    }

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getSalt());
    }
}
