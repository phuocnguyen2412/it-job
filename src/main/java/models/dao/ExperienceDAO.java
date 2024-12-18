package models.dao;

import config.Database;
import models.bean.Experience;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienceDAO {
    public Experience getExperienceByUserId(int userId) {
        String sql = "SELECT * FROM Experience WHERE userId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Experience experience = new Experience();
                    experience.setId(rs.getInt("id"));
                    experience.setCompany(rs.getString("company"));
                    experience.setUserId(rs.getInt("userId"));
                    experience.setPosition(rs.getString("position"));
                    experience.setDetail(rs.getString("detail"));
                    experience.setDateStart(rs.getTimestamp("dateStart"));
                    experience.setDateEnd(rs.getTimestamp("dateEnd"));
                    return experience;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updateExperience(Experience experience) {
        String sql = "UPDATE Experience SET company = ?, userId = ?, position = ?, detail = ?, dateStart = ?, dateEnd = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, experience.getCompany());
            stmt.setInt(2, experience.getUserId());
            stmt.setString(3, experience.getPosition());
            stmt.setString(4, experience.getDetail());
            stmt.setTimestamp(5, experience.getDateStart());
            stmt.setTimestamp(6, experience.getDateEnd());
            stmt.setInt(7, experience.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteExperience(int id) {
        String sql = "DELETE FROM Experience WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
