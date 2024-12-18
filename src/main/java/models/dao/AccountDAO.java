package models.dao;

import config.Database;
import models.bean.Account;
import models.bean.Company;

import java.sql.*;

public class AccountDAO {
    public Account getAccount(String email, byte[] password) {
        String query = """
        SELECT a.*, r.Name AS RoleName FROM ITJOB.Account a JOIN ITJOB.Role r ON a.RoleId = r.Id 
        WHERE a.Email = ? AND a.Password = ?""";
        Account result = new Account();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setBytes(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.setId(rs.getInt("Id"));
                    result.setEmail(rs.getString("Email"));
                    result.setPassword(rs.getBytes("Password"));
                    result.setRoleId(rs.getInt("RoleId"));
                    result.setRoleName(rs.getString("RoleName"));
                    result.setIsLocked(rs.getInt("isLocked"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkExistEmail(String email) {
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
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int handleCreateUser(String name, String email, byte[] password) {
        String query = "INSERT INTO Account (Password, Email, RoleId) VALUES (?, ?, ?)";
        int result = 0;
        int accountId = 0;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setBytes(1, password);
            stmt.setString(2, email);
            stmt.setInt(3, 1);

            result = stmt.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        accountId = rs.getInt(1);
                    }
                }
            } else return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        query = "INSERT INTO User (Name, AccountId, Email) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setInt(2, accountId);
            stmt.setString(3, email);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int handleCreateCompanyAccount(String email, byte[] password, String name, String logo) {
        int result;
        String query = "INSERT INTO Account (Email, Password, RoleId, isLocked) VALUES (?, ?, ?, ?)";
        int accountId = 0;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, email);
            stmt.setBytes(2, password);
            stmt.setInt(3, 3); // 3: company
            stmt.setInt(4, 0);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    accountId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        query = "INSERT INTO Company(Name, Email, Logo, AccountId) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, logo);
            stmt.setInt(4, accountId);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleUnlockAccount(int Id) {
        String query = "UPDATE Account SET isLooked = '0' WHERE Id = ?";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int handleLockAccount(int Id) {
        String query = "UPDATE Account SET isLooked = '1' WHERE Id = ?";
        int result = 0;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}