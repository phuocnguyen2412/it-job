package models.dao;

import config.Database;
import models.bean.Education;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EducationDAO {
    public boolean addEducation(Education education) {
        String sql = "INSERT INTO Education (userId, school, specialize, dateStart, dateEnd) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, education.getUserId());
            stmt.setString(2, education.getSchool());
            stmt.setString(3, education.getSpecialize());
            stmt.setTimestamp(4, education.getDateStart());
            stmt.setTimestamp(5, education.getDateEnd());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEducation(Education education) {
        String sql = "UPDATE Education SET userId = ?, school = ?, specialize = ?, dateStart = ?, dateEnd = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, education.getUserId());
            stmt.setString(2, education.getSchool());
            stmt.setString(3, education.getSpecialize());
            stmt.setTimestamp(4, education.getDateStart());
            stmt.setTimestamp(5, education.getDateEnd());
            stmt.setInt(6, education.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteEducation(int id) {
        String sql = "DELETE FROM Education WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public List<Education> getAllEducation() throws SQLException {
//        List<Education> educations = new ArrayList<>();
//        String sql = "SELECT * FROM Education";
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                Education education = new Education();
//                education.setId(rs.getInt("id"));
//                education.setUserId(rs.getInt("userId"));
//                education.setSchool(rs.getString("school"));
//                education.setSpecialize(rs.getString("specialize"));
//                education.setDateStart(rs.getTimestamp("dateStart"));
//                education.setDateEnd(rs.getTimestamp("dateEnd"));
//
//                educations.add(education);
//            }
//        }
//        return educations;
//    }

    public ArrayList<Education> getEducationByUserId(int userId) {
        ArrayList<Education> result = new ArrayList<>();
        String sql = "SELECT * FROM Education WHERE userId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Education education = new Education();
                    education.setId(rs.getInt("id"));
                    education.setUserId(rs.getInt("userId"));
                    education.setSchool(rs.getString("school"));
                    education.setSpecialize(rs.getString("specialize"));

                    result.add(education);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
