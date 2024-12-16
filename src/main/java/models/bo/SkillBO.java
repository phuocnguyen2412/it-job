package models.bo;

import models.bean.Skill;
import models.dao.SkillDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SkillBO {
    private final SkillDAO skillDAO;

    public SkillBO(Connection connection) {
        this.skillDAO = new SkillDAO(connection);
    }

    public List<Skill> getSkillsByUserId(int userId) throws SQLException {
        return skillDAO.getSkillsByUserId(userId);
    }

    public boolean addSkill(Skill skill) throws SQLException {
        return skillDAO.addSkill(skill);
    }

    public boolean updateSkill(Skill skill) throws SQLException {
        return skillDAO.updateSkill(skill);
    }

    public boolean deleteSkill(int id) throws SQLException {
        return skillDAO.deleteSkill(id);
    }
}
