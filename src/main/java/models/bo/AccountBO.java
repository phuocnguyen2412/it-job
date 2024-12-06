package models.bo;

import models.bean.Account;
import models.dao.AccountDAO;

public class AccountBO {
    public static boolean checkLogin(Account account) {
        boolean check = AccountDAO.checkAccount(account);
        return check;
    }
}
