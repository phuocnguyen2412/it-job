package models.bo;

import models.bean.Education;
import models.dao.EducationDAO;

import java.sql.SQLException;

public class EducationBO {
    EducationDAO educationDAO = new EducationDAO();

    public boolean addEducation(Education education) throws SQLException {
        return educationDAO.addEducation(education);
    }

    public boolean updateEducation(Education education) throws SQLException {
        return educationDAO.updateEducation(education);
    }

    public boolean deleteEducation(int id) throws SQLException {
        return educationDAO.deleteEducation(id);
    }

    public Education getEducationByUserId(int userId) throws SQLException {
        return educationDAO.getEducationByUserId(userId);
    }

//    public List<Education> getAllEducation() throws SQLException {
//        return educationDAO.getAllEducation();
//    }
}
