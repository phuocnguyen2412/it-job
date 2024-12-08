package models.dao;

import config.Database;
import models.bean.CompanyReview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyReviewDAO {
    public static int handleCreateCompanyReview(CompanyReview companyReview){
        String query = "INSERT INTO CompanyReview (UserId, Detail, Point, CreatedAt, CompanyId) " +
                       "VALUES(?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, companyReview.getUserId());
            stmt.setString(2, companyReview.getDetail());
            stmt.setInt(3, companyReview.getPoint());
            stmt.setTimestamp(4, companyReview.getCreatedAt());
            stmt.setInt(5, companyReview.getCompanyId());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int handleEditCompanyReview(CompanyReview companyReview){
        String query = "UPDATE CompanyReview SET Detail = ?, CompanyId = ? WHERE Id = ?";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, companyReview.getDetail());
            stmt.setInt(2, companyReview.getCompanyId());
            stmt.setInt(3, companyReview.getId());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int handleDeleteCompanyReview(int Id){
        String query = "DELETE FROM CompanyReview WHERE Id = ?";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static CompanyReview getCompanyReviewById(int Id){
        CompanyReview result = new CompanyReview();
        String query = "SELECT * FROM CompanyReview WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    result.setId(rs.getInt("Id"));
                    result.setUserId(rs.getInt("UserId"));
                    result.setDetail(rs.getString("Detail"));
                    result.setPoint(rs.getInt("Point"));
                    result.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    result.setCompanyId(rs.getInt("CompanyId"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static ArrayList<CompanyReview> getCompanyReviewList(){
        ArrayList<CompanyReview> result = new ArrayList<>();
        String query = "SELECT * FROM CompanyReview ORDER BY Point DESC LIMIT 4 ";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    CompanyReview companyReview = new CompanyReview();
                    companyReview.setId(rs.getInt("Id"));
                    companyReview.setUserId(rs.getInt("UserId"));
                    companyReview.setDetail(rs.getString("Detail"));
                    companyReview.setPoint(rs.getInt("Point"));
                    companyReview.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    companyReview.setCompanyId(rs.getInt("CompanyId"));

                    result.add(companyReview);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
