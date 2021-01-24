package de.hhu.propra.webserver.model.repositoryabstraction;

import de.hhu.propra.webserver.model.User;

public interface IUserRepository {

    public User findUserByUsername(String username);

    public void save(User user);
}
