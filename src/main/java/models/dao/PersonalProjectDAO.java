package models.dao;

import config.Database;
import models.bean.PersonalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalProjectDAO {
    public ArrayList<PersonalProject> getProjectsByUserId(int userId) {
        ArrayList<PersonalProject> projects = new ArrayList<>();
        String sql = "SELECT * FROM `persional project` WHERE UserId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PersonalProject project = new PersonalProject();
                    project.setId(rs.getInt("Id"));
                    project.setName(rs.getString("Name"));
                    project.setDateStart(rs.getTimestamp("DateStart"));
                    project.setDateEnd(rs.getTimestamp("DateEnd"));
                    project.setDetail(rs.getString("Detail"));
                    project.setLink(rs.getString("Link"));
                    project.setUserId(rs.getInt("UserId"));
                    projects.add(project);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }

    public boolean addProject(PersonalProject project) {
        String sql = "INSERT INTO `persional project` (Name, DateStart, DateEnd, Detail, Link, UserId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, project.getName());
            stmt.setTimestamp(2, project.getDateStart());
            stmt.setTimestamp(3, project.getDateEnd());
            stmt.setString(4, project.getDetail());
            stmt.setString(5, project.getLink());
            stmt.setInt(6, project.getUserId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateProject(PersonalProject project) {
        String sql = "UPDATE `persional project` SET Name = ?, DateStart = ?, DateEnd = ?, Detail = ?, Link = ? WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, project.getName());
            stmt.setTimestamp(2, project.getDateStart());
            stmt.setTimestamp(3, project.getDateEnd());
            stmt.setString(4, project.getDetail());
            stmt.setString(5, project.getLink());
            stmt.setInt(6, project.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProject(int id) {
        String sql = "DELETE FROM `persional project` WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
