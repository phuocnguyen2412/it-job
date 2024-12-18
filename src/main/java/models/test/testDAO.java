package models.test;

import models.bo.AccountBO;

public class testDAO {
    public static void main(String[] args) {
        new AccountBO().handleCreateCompanyAccount("company@gmail.com", "123456", "Axion", "https://th.bing.com/th?id=ORMS.e467f32f50c22acd569e6e2c8484d669&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1&p=0");
    }
}
