package models.bo;

import models.bean.Education;
import models.dao.EducationDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class EducationBO {
    private final EducationDAO educationDAO;

    public EducationBO() {
        this.educationDAO = new EducationDAO();
    }
    

    public boolean addEducation(Education education) throws SQLException {
        return educationDAO.addEducation(education);
    }

    public boolean updateEducation(Education education) throws SQLException {
        return educationDAO.updateEducation(education);
    }

    public boolean deleteEducation(int id) throws SQLException {
        return educationDAO.deleteEducation(id);
    }

    public ArrayList<Education> getEducationByUserId(int userId) {
        return educationDAO.getEducationByUserId(userId);
    }

//    public List<Education> getAllEducation() throws SQLException {
//        return educationDAO.getAllEducation();
//    }
}
