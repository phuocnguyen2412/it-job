package models.test;

import config.Database;

import java.sql.Connection;

public class testDAO {
    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        if (conn == null) {
            System.err.println("Kết nối cơ sở dữ liệu thất bại.");
        }


    }
}
