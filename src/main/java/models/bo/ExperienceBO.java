package models.bo;

import models.bean.Experience;
import models.dao.ExperienceDAO;

import java.sql.SQLException;

public class ExperienceBO {
    ExperienceDAO experienceDAO = new ExperienceDAO();

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
