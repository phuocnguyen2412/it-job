package models.dao;

import config.Database;
import models.bean.Account;

import java.sql.*;

public class AccountDAO {
    public static boolean checkAccount(Account account) {
        String sql = "SELECT COUNT(*) FROM Admin WHERE username = ? AND password = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static byte[] getPasswordByEmail(String email){
        String query = "SELECT Password FROM AccountUser JOIN User ON AccountUser.UserId = User.Id WHERE Email = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("Password");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static boolean checkExistEmail(String email){
        String query = "SELECT COUNT(*) FROM User WHERE Email = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static int handleCreateUser(String name, String email, byte[] password){
        String query = "";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            query = "";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}