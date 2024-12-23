package models.dao;

import config.Database;
import models.bean.Certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAO {
    public ArrayList<Certificate> getCertificatesByUserId(int userId) {
        ArrayList<Certificate> certificates = new ArrayList<>();
        String sql = "SELECT * FROM Certificate WHERE UserId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Certificate certificate = new Certificate();
                    certificate.setId(rs.getInt("id"));
                    certificate.setName(rs.getString("Name"));
                    certificate.setOrganization(rs.getString("Organization"));
                    certificate.setDate(rs.getTimestamp("Date"));
                    certificate.setDetail(rs.getString("Detail"));
                    certificate.setLink(rs.getString("Link"));
                    certificate.setUserId(rs.getInt("UserId"));
                    certificates.add(certificate);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return certificates;
    }

    public boolean addCertificate(Certificate certificate) {
        String sql = "INSERT INTO Certificate (name, organization, date, detail, link, userId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, certificate.getName());
            stmt.setString(2, certificate.getOrganization());
            stmt.setTimestamp(3, certificate.getDate());
            stmt.setString(4, certificate.getDetail());
            stmt.setString(5, certificate.getLink());
            stmt.setInt(6, certificate.getUserId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCertificate(Certificate certificate) {
        String sql = "UPDATE Certificate SET name = ?, organization = ?, date = ?, detail = ?, link = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, certificate.getName());
            stmt.setString(2, certificate.getOrganization());
            stmt.setTimestamp(3, certificate.getDate());
            stmt.setString(4, certificate.getDetail());
            stmt.setString(5, certificate.getLink());
            stmt.setInt(6, certificate.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCertificate(int id) {
        String sql = "DELETE FROM Certificate WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
