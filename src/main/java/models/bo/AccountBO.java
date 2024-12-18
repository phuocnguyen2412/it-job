package models.bo;

import exception.BadRequestException;
import models.bean.Account;
import models.bean.Company;
import models.dao.AccountDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class AccountBO {
    AccountDAO accountDAO = new AccountDAO();

    public Account checkSignIn(String email, String password) {
        byte[] inputPassword = fromPasswordToHashCode(password);
        Account account = accountDAO.getAccount(email, inputPassword);
        if(account == null) throw new BadRequestException();
        return account;
    }

    public byte[] fromPasswordToHashCode(String password){
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

    public int handleCreateUser(String name, String email, String password) throws BadRequestException {
        if(checkExistEmail(email)){
            throw new BadRequestException("Email đã tồn tại!");
        }
        return accountDAO.handleCreateUser(name, email, fromPasswordToHashCode(password));
    }

    public int handleCreateCompanyAccount(Company company, Account account, String password) throws BadRequestException{
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
