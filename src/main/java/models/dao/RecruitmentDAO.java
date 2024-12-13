package models.dao;

import config.Database;
import models.bean.Recruitment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruitmentDAO {
    public static int handleCreateRecruitment(Recruitment recruitment){
        String query = "INSERT INTO Recruitment (Position, RangeOfSalaryFrom, RangeOfSalaryTo, CompanyId, CreatedAt, Requirement, Benefit, JobDescription) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, recruitment.getPosition());
            stmt.setInt(2, recruitment.getRangeOfSalaryFrom());
            stmt.setInt(3, recruitment.getRangeOfSalaryTo());
            stmt.setInt(4, recruitment.getCompanyId());
            stmt.setTimestamp(5, recruitment.getCreatedAt());
            stmt.setString(6, recruitment.getRequirement());
            stmt.setString(7, recruitment.getBenefit());
            stmt.setString(8, recruitment.getJobDescription());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int handleEditRecruitment(Recruitment recruitment){
        String query = "UPDATE Recruitment SET Position = ?, RangeOfSalaryFrom = ?, RangeOfSalaryTo = ?, " +
                "Requirement = ?, Benefit = ?, JobDescription = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, recruitment.getPosition());
            stmt.setInt(2, recruitment.getRangeOfSalaryFrom());
            stmt.setInt(3, recruitment.getRangeOfSalaryTo());
            stmt.setString(4, recruitment.getRequirement());
            stmt.setString(5, recruitment.getBenefit());
            stmt.setString(6, recruitment.getJobDescription());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int handleDeleteRecruitment(int recruitmentId){
        String query = "DELETE FROM Recruitment WHERE Id = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recruitmentId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Recruitment getRecruitmentById(int recruitmentId){
        String query = "SELECT * FROM Recruitment WHERE Id = ?";
        Recruitment result = new Recruitment();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recruitmentId);

            try(ResultSet rs = stmt.executeQuery()){
                result.setId(rs.getInt("Id"));
                result.setCompanyId(rs.getInt("CompanyId"));
                result.setPosition(rs.getString("Position"));
                result.setCreatedAt(rs.getTimestamp("CreatedAt"));
                result.setBenefit(rs.getString("Benefit"));
                result.setJobDescription(rs.getString("JobDescription"));
                result.setRangeOfSalaryFrom(rs.getInt("RangeOfSalaryFrom"));
                result.setRangeOfSalaryTo(rs.getInt("RangeOfSalaryTo"));
                result.setRequirement(rs.getString("Requirement"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
