package web.repo;

import web.model.User;

import java.util.List;

public interface UserRepo {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User getUser(long id);

    User deleteUser(long id);
}