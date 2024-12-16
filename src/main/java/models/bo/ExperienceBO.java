package models.bo;

import models.bean.Experience;
import models.dao.ExperienceDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class ExperienceBO {
    private ExperienceDAO experienceDAO;

    public ExperienceBO(Connection connection) {
        this.experienceDAO = new ExperienceDAO(connection);
    }

    public Experience getExperienceById(int userId) throws SQLException {
        return experienceDAO.getExperienceByUserId(userId);
    }

    public boolean updateExperience(Experience experience) throws SQLException {
        return experienceDAO.updateExperience(experience);
    }

    public boolean deleteExperience(int id) throws SQLException {
        return experienceDAO.deleteExperience(id);
    }
}
