package models.dao;

import config.Database;
import models.bean.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public List<NhanVien> findNhanVien(String key, String value) {
        String query = "SELECT * FROM NhanVien WHERE " + key + " LIKE ?";
        List<NhanVien> nhanVienList = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + value + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    nhanVienList.add(new NhanVien(
                            rs.getString("DiaChi"),
                            rs.getString("IDPB"),
                            rs.getString("HoTen"),
                            rs.getString("IDNV")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    public boolean createNhanVien(NhanVien nhanVien) {
        String query = "INSERT INTO NhanVien (IDNV, HoTen, IDPB, DiaChi) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nhanVien.getIDNV());
            stmt.setString(2, nhanVien.getHoTen());
            stmt.setString(3, nhanVien.getIDPB());
            stmt.setString(4, nhanVien.getDiaChi());
            return stmt.executeUpdate() > 0; // Trả về true nếu thêm thành công
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMultiNhanVien(String[] ids) {
        String query = "DELETE FROM NhanVien WHERE IDNV = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            for (String id : ids) {
                stmt.setString(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateNhanVien(NhanVien nhanVien) {
        String query = "UPDATE NhanVien SET HoTen = ?, IDPB = ?, DiaChi = ? WHERE IDNV = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nhanVien.getHoTen());
            stmt.setString(2, nhanVien.getIDPB());
            stmt.setString(3, nhanVien.getDiaChi());
            stmt.setString(4, nhanVien.getIDNV());
            return stmt.executeUpdate() > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> getAllNhanVien() {
        String query = "SELECT * FROM NhanVien";
        List<NhanVien> nhanVienList = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nhanVienList.add(new NhanVien(
                        rs.getString("DiaChi"),
                        rs.getString("IDPB"),

                        rs.getString("HoTen"),
                        rs.getString("IDNV")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    public boolean deleteNhanVien(String id) {
        System.out.println("IDNV: " + id);
        String query = "DELETE FROM NhanVien WHERE IDNV = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0; // Trả về true nếu xóa thành công
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> getAllNhanVienInPhongBan(String id) {
        String query = "SELECT * FROM NhanVien WHERE IDPB = ?";
        List<NhanVien> nhanVienList = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    nhanVienList.add(new NhanVien(
                            rs.getString("DiaChi"),
                            rs.getString("IDPB"),
                            rs.getString("HoTen"),
                            rs.getString("IDNV")

                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    public NhanVien getNhanVienById(String id) {
        System.out.println("IDNV: " + id);
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM NhanVien WHERE IDNV = ?")) {
            stmt.setString(1, id);
            stmt.executeQuery();
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NhanVien(
                            rs.getString("DiaChi"),
                            rs.getString("IDPB"),

                            rs.getString("HoTen"),
                            rs.getString("IDNV"));


                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
