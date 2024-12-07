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
        String query = "INSERT INTO `user`(Name, Email, Role) VALUES (?, ?, ?)";
        int userId = 0;
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, "Employee");

            result = stmt.executeUpdate();
            if(result > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        userId = rs.getInt(1);
                    }
                }
            }
            else return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        query = "INSERT INTO `accountuser`(UserId, Password) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setBytes(2, password);

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}