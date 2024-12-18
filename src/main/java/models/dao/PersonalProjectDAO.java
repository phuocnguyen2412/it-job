package models.dao;

import config.Database;
import models.bean.PersonalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalProjectDAO {
    public List<PersonalProject> getProjectsByUserId(int userId) {
        List<PersonalProject> projects = new ArrayList<>();
        String sql = "SELECT * FROM Personal Project WHERE userId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PersonalProject project = new PersonalProject();
                    project.setId(rs.getInt("id"));
                    project.setName(rs.getString("name"));
                    project.setDateStart(rs.getTimestamp("dateStart"));
                    project.setDateEnd(rs.getTimestamp("dateEnd"));
                    project.setDetail(rs.getString("detail"));
                    project.setLink(rs.getString("link"));
                    project.setUserId(rs.getInt("userId"));
                    projects.add(project);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }

    public boolean addProject(PersonalProject project) {
        String sql = """INSERT INTO Personal Project (name, dateStart, dateEnd, detail, link, userId) VALUES (?, ?, ?, ?, ?, ?)""";
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
        String sql = "UPDATE Personal Project SET name = ?, dateStart = ?, dateEnd = ?, detail = ?, link = ? WHERE id = ?";
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
        String sql = "DELETE FROM Personal Project WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
