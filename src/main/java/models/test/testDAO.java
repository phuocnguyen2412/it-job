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

            // Tạo đối tượng User mới
            User newUser = new User();
            newUser.setName("Trần Nguyên Tâm");
            newUser.setIntroduce("HelloAE");
            newUser.setEmail("trannguyentam2004@gmail.com");
            newUser.setPhoneNumber("0375053769");
            newUser.setBirthday(java.sql.Date.valueOf("2004-12-28"));
            newUser.setCity("Thừa Thiên Huế");
            newUser.setAvatar(null);
            newUser.setAccountId(1);

            // Thêm người dùng vào cơ sở dữ liệu
            boolean success = userDAO.addUser(newUser);  // Phương thức addUser trả về boolean

            if (success) {
                System.out.println("Thêm người dùng thành công.");

                // Sau khi thêm người dùng, lấy danh sách tất cả người dùng
                List<User> users = userDAO.getAllUsers();  // Lấy danh sách người dùng từ cơ sở dữ liệu

                if (users.isEmpty()) {
                    System.out.println("Không có người dùng nào trong cơ sở dữ liệu.");
                } else {
                    System.out.println("Danh sách người dùng sau khi thêm:");
                    for (User user : users) {
                        System.out.println(user);
                    }
                }
            } else {
                System.out.println("Thêm người dùng thất bại.");
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
