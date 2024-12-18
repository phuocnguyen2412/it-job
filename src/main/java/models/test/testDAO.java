package models.test;

import config.Database;
import models.bean.User;
import models.dao.UserDAO;

import java.sql.Connection;
import java.util.List;

public class testDAO {
    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        if (conn == null) {
            System.err.println("Kết nối cơ sở dữ liệu thất bại.");
            return;
        }

        try {
            UserDAO userDAO = new UserDAO();
            User newUser = new User();
            newUser.setName("Trần Nguyên Tâm");
            newUser.setIntroduce("HelloAE");
            newUser.setEmail("trannguyentam2004@gmail.com");
            newUser.setPhoneNumber("0375053769");
            newUser.setBirthday(java.sql.Date.valueOf("2004-12-28")); // Định dạng yyyy-MM-dd
            newUser.setCity("Thừa Thiên Huế");
            newUser.setAvatar(null); // Nếu không có avatar
            newUser.setAccountId(1); // ID tài khoản

            // Truyền đối tượng User vào phương thức addUser
            List<User> users = userDAO.addUser(newUser);
            if (users.isEmpty()) {
                System.out.println("Không có người dùng nào trong cơ sở dữ liệu.");
            } else {
                System.out.println(users);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi truy vấn cơ sở dữ liệu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Đóng kết nối cơ sở dữ liệu thành công.");
                }
            } catch (Exception e) {
                System.err.println("Lỗi khi đóng kết nối cơ sở dữ liệu: " + e.getMessage());
            }
        }
    }
}
