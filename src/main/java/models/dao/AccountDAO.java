package models.dao;

import config.Database;
import models.bean.Account;
import models.bean.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public Account getAccount(String email, byte[] password) {
        String query = "SELECT * FROM Account WHERE Email = ? AND Password = ?";
        Account result = new Account();
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setBytes(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.setId(rs.getInt("Id"));
                    result.setAdminId(rs.getInt("AdminId"));
                    result.setEmail(rs.getString("Email"));
                    result.setPassword(rs.getBytes("Password"));
                    result.setRoleId(rs.getInt("RoleId"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
        return false;
    }

    public int handleCreateUser(String name, String email, byte[] password) {
        String query = "INSERT INTO Role (Name) VALUES (?)";
        int roleId = 0;
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "Employee");

            result = stmt.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        roleId = rs.getInt(1);
                    }
                }
            } else return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int accountId = 0;
        query = "INSERT INTO Account (Password, Email, RoleId) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBytes(1, password);
            stmt.setString(2, email);
            stmt.setInt(3, roleId);

            result = stmt.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        accountId = rs.getInt(1);
                    }
                }
            } else return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        query = "INSERT INTO User (Name, AccountId) VALUES (?, ?)";
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

    public int handleCreateCompanyAccount(Company company, Account account) {
        int result;
        int roleId = 0;
        String query = "INSERT INTO Role(Name) VALUES (?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "Company");
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    roleId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int accountId = 0;
        query = "INSERT INTO Account (AdminId, Email, Password, RoleId, isLocked) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, account.getAdminId());
            stmt.setString(2, account.getEmail());
            stmt.setBytes(3, account.getPassword());
            stmt.setInt(4, roleId);
            stmt.setInt(5, 0);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    accountId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        query = "UPDATE Company SET AccountId = ? WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, accountId);
            stmt.setInt(2, company.getId());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleUnlockAccount(int Id) {
        String query = "UPDATE Account SET isLooked = '0' WHERE Id = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int handleLockAccount(int Id) {
        String query = "UPDATE Account SET isLooked = '1' WHERE Id = ?";
        int result;
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}