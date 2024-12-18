package models.bo;

import models.bean.Account;
import models.bean.Company;
import models.dao.AccountDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccountBO {
    private AccountDAO accountDAO;

    public AccountBO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account checkSignIn(String email, String password) {
        byte[] inputPassword = fromPasswordToHashCode(password);

        return accountDAO.getAccount(email, inputPassword);
    }

    public byte[] fromPasswordToHashCode(String password) {
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

    public boolean checkExistEmail(String email) {
        return accountDAO.checkExistEmail(email);
    }

    public int handleCreateUser(String name, String email, String password) {
        return accountDAO.handleCreateUser(name, email, fromPasswordToHashCode(password));
    }

    public int handleCreateCompanyAccount(Company company, Account account, String password) {
        account.setPassword(fromPasswordToHashCode(password));
        return accountDAO.handleCreateCompanyAccount(company, account);
    }

    public int unlockCompanyAccount(int companyId) {
        return accountDAO.handleUnlockAccount(companyId);
    }

    public int lockCompanyAccount(int companyId) {
        return accountDAO.handleLockAccount(companyId);
    }

    public int unlockUserAccount(int userId) {
        return accountDAO.handleLockAccount(userId);
    }

    public int lockUserAccount(int userId) {
        return accountDAO.handleUnlockAccount(userId);
    }
}
