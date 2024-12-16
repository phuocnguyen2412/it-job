package models.dao;

import models.bean.Experience;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienceDAO {
    private final Connection connection;

    public ExperienceDAO(Connection connection) {
        this.connection = connection;
    }

    public Experience getExperienceByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM Experience WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        }
        return null;
    }

    public boolean updateExperience(Experience experience) throws SQLException {
        String sql = "UPDATE Experience SET company = ?, userId = ?, position = ?, detail = ?, dateStart = ?, dateEnd = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, experience.getCompany());
            stmt.setInt(2, experience.getUserId());
            stmt.setString(3, experience.getPosition());
            stmt.setString(4, experience.getDetail());
            stmt.setTimestamp(5, experience.getDateStart());
            stmt.setTimestamp(6, experience.getDateEnd());
            stmt.setInt(7, experience.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteExperience(int id) throws SQLException {
        String sql = "DELETE FROM Experience WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
