package models.bo;

import models.bean.Account;
import models.dao.AccountDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccountBO {
    public static boolean checkLogin(Account account) {
        boolean check = AccountDAO.checkAccount(account);
        return check;
    }
    public static Boolean checkSignIn(String email, String password){
        byte[] inputPassword = fromPasswordToHashCode(password);
        byte[] storedPassword = AccountDAO.getPasswordByEmail(email);

        return Arrays.equals(inputPassword, storedPassword);
    }
    public static byte[] fromPasswordToHashCode(String password){
        try {
            // Tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Chuyển đổi password thành mảng byte và hash
            return digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
