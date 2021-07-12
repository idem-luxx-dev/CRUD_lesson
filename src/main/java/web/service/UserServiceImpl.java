package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repo.UserRepo;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (0 == user.getId()) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    private void createUser(User user) {
        repo.createUser(user);
    }

    private void updateUser(User user) {
        repo.updateUser(user);
    }

    @Override
    public User getUser(long id) {
        return repo.getUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = repo.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}