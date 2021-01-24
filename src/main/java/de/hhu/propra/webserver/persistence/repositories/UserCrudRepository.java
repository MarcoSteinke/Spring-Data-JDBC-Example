package de.hhu.propra.webserver.persistence.repositories;

import de.hhu.propra.webserver.persistence.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<UserDTO, String> {

}
