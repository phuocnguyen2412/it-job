package models.bo;

import models.bean.Education;
import models.dao.EducationDAO;

import java.sql.SQLException;
import java.sql.Timestamp;

public class EducationBO {
    private final EducationDAO educationDAO;

    public EducationBO() {
        this.educationDAO = new EducationDAO();
    }

    public Education mockData() {
        Education education = new Education();
        education.setUserId(1);
        education.setSchool("University of Science");
        education.setSpecialize("Information Technology");

        education.setDateStart(Timestamp.valueOf("2020-01-01 00:00:00"));
        education.setDateEnd(Timestamp.valueOf("2024-01-01 00:00:00"));

        return education;
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

    public Education getEducationByUserId(int userId) throws SQLException {
        return educationDAO.getEducationByUserId(userId);
    }

//    public List<Education> getAllEducation() throws SQLException {
//        return educationDAO.getAllEducation();
//    }
}
