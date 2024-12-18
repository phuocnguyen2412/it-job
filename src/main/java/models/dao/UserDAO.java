package models.dao;

import config.Database;
import models.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User getUserByAccountId(int accountId) {
        User user = null;
        String sql = "SELECT * FROM User WHERE AccountId = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM User WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO User (Name, Introduce, Email, PhoneNumber, Birthday, City, Avatar, AccountId, Skills) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getIntroduce());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setDate(5, user.getBirthday());
            stmt.setString(6, user.getCity());
            stmt.setBytes(7, user.getAvatar());
            stmt.setInt(8, user.getAccountId());
            stmt.setString(9, user.getSkills() == null ? "" : String.valueOf(user.getSkills()));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        String query = "UPDATE User SET Name = ?, Introduce = ?, Email = ?, PhoneNumber = ?, Birthday = ?, City = ?, Avatar = ?, Skills = ? WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getIntroduce());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setDate(5, user.getBirthday());
            stmt.setString(6, user.getCity());
            stmt.setBytes(7, user.getAvatar());
            stmt.setString(8, user.getSkills() == null ? "" : String.valueOf(user.getSkills()));
            stmt.setInt(9, user.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM User WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> searchUsersByName(String name) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User WHERE name LIKE ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    users.add(mapResultSetToUser(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("Id"));
        user.setName(rs.getString("Name"));
        user.setIntroduce(rs.getString("Introduce"));
        user.setEmail(rs.getString("Email"));
        user.setPhoneNumber(rs.getString("PhoneNumber"));
        user.setBirthday(rs.getDate("Birthday"));
        user.setCity(rs.getString("City"));
        user.setAvatar(rs.getBytes("Avatar"));
        user.setAccountId(rs.getInt("AccountId"));
        user.setSkills(rs.getString("Skills") == null ? "" : rs.getString("Skills"));
        return user;
    }

}
