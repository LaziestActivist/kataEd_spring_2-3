package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void save(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void update(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void delete(int id) {
        userDAO.deleteUser(id);
    }
}