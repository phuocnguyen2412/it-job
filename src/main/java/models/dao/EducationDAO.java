package models.dao;

import models.bean.Education;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDAO {
    private final Connection connection;

    public EducationDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addEducation(Education education) throws SQLException {
        String sql = "INSERT INTO Education (userId, school, specialize, dateStart, dateEnd) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, education.getUserId());
            stmt.setString(2, education.getSchool());
            stmt.setString(3, education.getSpecialize());
            stmt.setTimestamp(4, education.getDateStart());
            stmt.setTimestamp(5, education.getDateEnd());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateEducation(Education education) throws SQLException {
        String sql = "UPDATE Education SET userId = ?, school = ?, specialize = ?, dateStart = ?, dateEnd = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, education.getUserId());
            stmt.setString(2, education.getSchool());
            stmt.setString(3, education.getSpecialize());
            stmt.setTimestamp(4, education.getDateStart());
            stmt.setTimestamp(5, education.getDateEnd());
            stmt.setInt(6, education.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteEducation(int id) throws SQLException {
        String sql = "DELETE FROM Education WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
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

    public Education getEducationByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM Education WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Education education = new Education();
                    education.setId(rs.getInt("id"));
                    education.setUserId(rs.getInt("userId"));
                    education.setSchool(rs.getString("school"));
                    education.setSpecialize(rs.getString("specialize"));
                    education.setDateStart(rs.getTimestamp("dateStart"));
                    education.setDateEnd(rs.getTimestamp("dateEnd"));

                    return education;
                }
            }
        }
        return null;
    }
}
