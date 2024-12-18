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
        String sql = "INSERT INTO User (name, introduce, email, phoneNumber, birthday, city, avatar, accountId, skills) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getIntroduce());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setDate(5, user.getBirthday());
            stmt.setString(6, user.getCity());
            stmt.setBytes(7, user.getAvatar());
            stmt.setInt(8, user.getAccountId());
            stmt.setString(9, String.join(",", user.getSkills()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE User SET name = ?, introduce = ?, email = ?, phoneNumber = ?, birthday = ?, city = ?, avatar = ?, accountId = ?, skills = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getIntroduce());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setDate(5, user.getBirthday());
            stmt.setString(6, user.getCity());
            stmt.setBytes(7, user.getAvatar());
            stmt.setInt(8, user.getAccountId());
            stmt.setString(9, String.join(",", user.getSkills()));
            stmt.setInt(10, user.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setIntroduce(rs.getString("introduce"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setBirthday(rs.getDate("birthday"));
        user.setCity(rs.getString("city"));
        user.setAvatar(rs.getBytes("avatar"));
        user.setAccountId(rs.getInt("accountId"));

        // Sử dụng rs.getString() để lấy dữ liệu skills và chuyển thành List<String>
        String skillsString = rs.getString("skills");
        if (skillsString != null && !skillsString.isEmpty()) {
            user.setSkills(skillsString);  // Gọi setter đã có cho skills (loại String)
        } else {
            user.setSkills("");  // Hoặc gán chuỗi rỗng nếu không có dữ liệu
        }

        return user;
    }

}
