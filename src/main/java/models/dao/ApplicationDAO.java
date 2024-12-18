package models.dao;

import config.Database;
import models.bean.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDAO {
    public void apply(Application application) {
        String query = "INSERT INTO Application (UserId, RecruitmentId, CV, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, application.getUserId());
            stmt.setInt(2, application.getRecruitmentId());
            stmt.setString(3, application.getCv());
            stmt.setString(4, "Pending");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Application application) {
        String query = "UPDATE Application SET CV = ? WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, application.getCv());
            stmt.setInt(2, application.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int applicationId) {
        String query = "DELETE FROM Application WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Application getAppication(int userId, int recruitmentId) {
        Application application = null;
        String query = "SELECT * FROM Application WHERE UserId = ? and RecruitmentId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, recruitmentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                application = new Application();
                application.setId(rs.getInt("Id"));
                application.setUserId(rs.getInt("UserId"));
                application.setRecruitmentId(rs.getInt("RecruitmentId"));
                application.setCv(rs.getString("CV"));
                application.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }

    public Application findByStatus(int userId) {
        Application application = null;
        String query = "SELECT * FROM Application WHERE UserId = ? and Status = 'Pending'";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                application = new Application();
                application.setId(rs.getInt("Id"));
                application.setUserId(rs.getInt("UserId"));
                application.setRecruitmentId(rs.getInt("RecruitmentId"));
                application.setCv(rs.getString("CV"));
                application.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }
}
