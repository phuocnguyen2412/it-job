package models.bo;

import models.bean.Certificate;
import models.bean.Education;
import models.bean.PersonalProject;
import models.bean.User;
import models.dao.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBO {
    UserDAO userDAO = new UserDAO();
    PersonalProjectBO personalProjectBO = new PersonalProjectBO();
    EducationBO educationBO = new EducationBO();


    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public User getUserById(int id) {
        User user = userDAO.getUserById(id);
        ArrayList<PersonalProject> personalProjects = personalProjectBO.getProjectsByUserId(id);
        ArrayList<Education> educations = educationBO.getEducationByUserId(id);
        user.setEducations(educations);
        user.setProjects(personalProjects);
        return user;
    }

    public boolean addUser(User user) throws SQLException {
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    public List<User> searchUsersByName(String name) throws SQLException {
        return userDAO.searchUsersByName(name);
    }

    public User getUserByAccountId(int accountId){
        return userDAO.getUserByAccountId(accountId);
    }
}
