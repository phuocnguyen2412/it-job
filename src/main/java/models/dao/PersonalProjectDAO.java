package models.dao;

import models.bean.PersonalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalProjectDAO {
    private final Connection connection;

    public PersonalProjectDAO(Connection connection) {
        this.connection = connection;
    }

    public List<PersonalProject> getProjectsByUserId(int userId) throws SQLException {
        List<PersonalProject> projects = new ArrayList<>();
        String sql = "SELECT * FROM PersonalProject WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        }
        return projects;
    }

    public boolean addProject(PersonalProject project) throws SQLException {
        String sql = "INSERT INTO PersonalProject (name, dateStart, dateEnd, detail, link, userId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, project.getName());
            stmt.setTimestamp(2, project.getDateStart());
            stmt.setTimestamp(3, project.getDateEnd());
            stmt.setString(4, project.getDetail());
            stmt.setString(5, project.getLink());
            stmt.setInt(6, project.getUserId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateProject(PersonalProject project) throws SQLException {
        String sql = "UPDATE PersonalProject SET name = ?, dateStart = ?, dateEnd = ?, detail = ?, link = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, project.getName());
            stmt.setTimestamp(2, project.getDateStart());
            stmt.setTimestamp(3, project.getDateEnd());
            stmt.setString(4, project.getDetail());
            stmt.setString(5, project.getLink());
            stmt.setInt(6, project.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteProject(int id) throws SQLException {
        String sql = "DELETE FROM PersonalProject WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
