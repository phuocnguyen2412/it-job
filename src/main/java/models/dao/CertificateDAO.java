package models.dao;

import config.Database;
import models.bean.Certificate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAO {


    public List<Certificate> getCertificatesByUserId(int userId) throws SQLException {
        List<Certificate> certificates = new ArrayList<>();
        String sql = "SELECT * FROM Certificate WHERE userId = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Certificate certificate = new Certificate();
                    certificate.setId(rs.getInt("id"));
                    certificate.setName(rs.getString("name"));
                    certificate.setOrganization(rs.getString("organization"));
                    certificate.setDate(rs.getTimestamp("date"));
                    certificate.setDetail(rs.getString("detail"));
                    certificate.setLink(rs.getString("link"));
                    certificate.setUserId(rs.getInt("userId"));
                    certificates.add(certificate);
                }
            }
        }
        return certificates;
    }

    public boolean addCertificate(Certificate certificate) throws SQLException {
        String sql = "INSERT INTO Certificate (name, organization, date, detail, link, userId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, certificate.getName());
            stmt.setString(2, certificate.getOrganization());
            stmt.setTimestamp(3, certificate.getDate());
            stmt.setString(4, certificate.getDetail());
            stmt.setString(5, certificate.getLink());
            stmt.setInt(6, certificate.getUserId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateCertificate(Certificate certificate) throws SQLException {
        String sql = "UPDATE Certificate SET name = ?, organization = ?, date = ?, detail = ?, link = ? WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setString(1, certificate.getName());
            stmt.setString(2, certificate.getOrganization());
            stmt.setTimestamp(3, certificate.getDate());
            stmt.setString(4, certificate.getDetail());
            stmt.setString(5, certificate.getLink());
            stmt.setInt(6, certificate.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteCertificate(int id) throws SQLException {
        String sql = "DELETE FROM Certificate WHERE id = ?";
        try (PreparedStatement stmt = Database.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
