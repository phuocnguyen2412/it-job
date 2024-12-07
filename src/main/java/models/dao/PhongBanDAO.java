package models.dao;

import config.Database;
import models.bean.PhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {
    public static List<PhongBan> getAllPhongBan() {
        String query = "SELECT * FROM PhongBan";
        List<PhongBan> phongBans = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                phongBans.add(new PhongBan(
                        rs.getString("IDPB"),
                        rs.getString("TenPB"),
                        rs.getString("MoTa")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongBans;
    }

    public static PhongBan getPhongBanById(String id) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PhongBan WHERE IDPB = ?")) {
            stmt.setString(1, id);
            stmt.executeQuery();
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PhongBan(
                            rs.getString("IDPB"),
                            rs.getString("TenPB"),
                            rs.getString("MoTa")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void updatePhongBan(PhongBan phongBan) {
        String query = "UPDATE PhongBan SET TenPB = ?, MoTa = ? WHERE IDPB = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, phongBan.getTenPB());
            stmt.setString(2, phongBan.getMoTa());
            stmt.setString(3, phongBan.getIDPB());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}