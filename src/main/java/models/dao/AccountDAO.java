package models.dao;

import config.Database;
import models.bean.Account;

import java.sql.*;

public class AccountDAO {
    public static byte[] getPasswordByEmail(String email){
        String query = "SELECT Password FROM Account WHERE Email = ?";
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
        String query = "SELECT COUNT(*) FROM Account WHERE Email = ?";
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
        String query = "INSERT INTO `Role`(Name) VALUES (?)";
        int roleId = 0;
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "Employee");

            result = stmt.executeUpdate();
            if(result > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        roleId = rs.getInt(1);
                    }
                }
            }
            else return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int accountId = 0;
        query = "INSERT INTO `Account`(Password, Email, RoleId) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBytes(1, password);
            stmt.setString(2, email);
            stmt.setInt(3, roleId);

            result = stmt.executeUpdate();
            if(result > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        accountId = rs.getInt(1);
                    }
                }
            }
            else return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        query = "INSERT INTO `User`(Name, AccountId) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setInt(2, accountId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}