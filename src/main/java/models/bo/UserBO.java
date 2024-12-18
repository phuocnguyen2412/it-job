package models.bo;

import models.bean.User;
import models.dao.UserDAO;

import java.util.List;

public class UserBO {
    private UserDAO userDAO;

    public UserBO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    public List<User> searchUsersByName(String name) {
        return userDAO.searchUsersByName(name);
    }
}
