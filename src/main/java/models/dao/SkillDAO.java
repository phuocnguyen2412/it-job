package models.dao;

import models.bean.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {
    private final Connection connection;

    public SkillDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Skill> getSkillsByUserId(int userId) throws SQLException {
        List<Skill> skills = new ArrayList<>();
        String sql = "SELECT * FROM Skill WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Skill skill = new Skill();
                    skill.setId(rs.getInt("id"));
                    skill.setName(rs.getString("name"));
                    skill.setUserId(rs.getInt("userId"));
                    skills.add(skill);
                }
            }
        }
        return skills;
    }

    public boolean addSkill(Skill skill) throws SQLException {
        String sql = "INSERT INTO Skill (name, userId) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getUserId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateSkill(Skill skill) throws SQLException {
        String sql = "UPDATE Skill SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteSkill(int id) throws SQLException {
        String sql = "DELETE FROM Skill WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
