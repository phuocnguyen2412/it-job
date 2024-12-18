package models.bo;

import models.bean.User;
import models.dao.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBO {
    private final UserDAO userDAO;

    public UserBO() {
        this.userDAO = new UserDAO();
    }

    public User mockData() {
        User user = new User();
        user.setId(1);
        user.setName("Nguyen Van A");
        user.setEmail("abc@gmail.com");
        user.setCity("Da nang");
        user.setPhoneNumber("0123456789");
        user.setBirthday(java.sql.Date.valueOf("1999-01-01"));
        user.setIntroduce("Hello");
        user.setAccountId(1);
        user.setCertificates(new ArrayList<Certificate>() {
            {
                add(new CertificateBO().mockData());
                add(new CertificateBO().mockData());
                add(new CertificateBO().mockData());
            }
        });

        return user;


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
