package models.bo;

import models.bean.*;
import models.dao.AccountDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AccountBO {
    public static Account checkSignIn(String email, String password){
        byte[] inputPassword = fromPasswordToHashCode(password);

        return AccountDAO.getAccount(email, inputPassword);
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

    public static boolean checkExistEmail(String email){
        return AccountDAO.checkExistEmail(email);
    }

    public static int handleCreateUser(String name, String email, String password){
        return AccountDAO.handleCreateUser(name, email, fromPasswordToHashCode(password));
    }

    public static int handleCreateCompanyAccount(Company company, Account account, String password){
        account.setPassword(fromPasswordToHashCode(password));
        return AccountDAO.handleCreateCompanyAccount(company, account);
    }
}
