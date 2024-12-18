package models.dao;

import config.Database;
import models.bean.Recruitment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecruitmentDAO {
    public int handleCreateRecruitment(Recruitment recruitment) {
        String query = """
                        INSERT INTO Recruitment (Position, RangeOfSalaryFrom, RangeOfSalaryTo, CompanyId, 
                                                 CreatedAt, Requirement, Benefit, JobDescription)
                        VALUES(?, ?, ?, ?, ?, ?, ?, ?)
                """;
        int result = 0;
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
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int handleEditRecruitment(Recruitment recruitment) throws SQLException {
        String query = """
                        UPDATE Recruitment SET Position = ?, RangeOfSalaryFrom = ?, RangeOfSalaryTo = ?, 
                        Requirement = ?, Benefit = ?, JobDescription = ?
                """;
        int result = 0;
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
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int handleDeleteRecruitment(int recruitmentId) throws SQLException {
        String query = "DELETE FROM Recruitment WHERE Id = ?";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recruitmentId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public Recruitment  getRecruitmentById(int recruitmentId) {
        String query = "SELECT * FROM Recruitment WHERE Id = ?";
        Recruitment result = new Recruitment();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recruitmentId);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    result = resultSetToRecruitment(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Recruitment  getRecruitmentByCompanyId(int companyId) {
        String query = "SELECT * FROM Recruitment WHERE companyId = ?";
        Recruitment result = new Recruitment();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyId);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    result = resultSetToRecruitment(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ArrayList<Recruitment> getRecruitmentBySearch(String countryInput, String searchBy, String searchInput) {
        ArrayList<Recruitment> result = new ArrayList<Recruitment>();
        String country = "";
        String query = """
                        SELECT * FROM Recruitment 
                        JOIN Company ON Company.Id = Recruitment.CompanyId 
                        WHERE Country LIKE ?
                """;
        if (!countryInput.equals("0")) country = countryInput;
        if (searchBy.equals("position")) {
            query += "AND Position LIKE ? ";
        } else {
            query += "AND Company.Name LIKE ?";
        }

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + country + "%");
            stmt.setString(2, "%" + searchInput + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Recruitment recruitment = resultSetToRecruitment(rs);
                    result.add(recruitment);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public ArrayList<Recruitment> getRecruitment() {
        ArrayList<Recruitment> result = new ArrayList<Recruitment>();
        String query = """
                        SELECT * FROM Recruitment ORDER BY CreatedAt DESC LIMIT 5
                """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Recruitment recruitment = resultSetToRecruitment(rs);
                    result.add(recruitment);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public Recruitment resultSetToRecruitment(ResultSet rs) throws SQLException {
        Recruitment recruitment = new Recruitment();
        recruitment.setId(rs.getInt("Id"));
        recruitment.setCompanyId(rs.getInt("CompanyId"));
        recruitment.setPosition(rs.getString("Position"));
        recruitment.setCreatedAt(rs.getTimestamp("CreatedAt"));
        recruitment.setBenefit(rs.getString("Benefit"));
        recruitment.setJobDescription(rs.getString("JobDescription"));
        recruitment.setRangeOfSalaryFrom(rs.getInt("RangeOfSalaryFrom"));
        recruitment.setRangeOfSalaryTo(rs.getInt("RangeOfSalaryTo"));
        recruitment.setRequirement(rs.getString("Requirement"));
        recruitment.setSkills(rs.getString("Skills"));
        return recruitment;
    }
}
