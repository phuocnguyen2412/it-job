package models.bo;

import models.bean.User;
import models.dao.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserBO {
    private final UserDAO userDAO;

    public UserBO(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public User getUserById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public List<User> addUser(User user) throws SQLException {
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    public List<User> searchUsersByName(String name) throws SQLException {
        return userDAO.searchUsersByName(name);
    }
    
}
