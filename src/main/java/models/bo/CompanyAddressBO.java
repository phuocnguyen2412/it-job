package models.bo;

import models.bean.CompanyAddress;
import models.dao.CompanyAddressDAO;

import java.util.ArrayList;

public class CompanyAddressBO {
    public static int handleCreateCompanyAddress(CompanyAddress companyAddress){
        return CompanyAddressDAO.handleCreateCompanyAddress(companyAddress);
    }

    public static int handleEditCompanyAddress(CompanyAddress companyAddress){
        return CompanyAddressDAO.handleEditCompanyAddress(companyAddress);
    }

    public static int handleDeleteCompanyAddress(int companyAddressId){
        return CompanyAddressDAO.handleDeleteCompanyAddress(companyAddressId);
    }

    public static ArrayList<CompanyAddress> getCompanyAddress(int companyId) {
        return CompanyAddressDAO.getCompanyAddress(companyId);
    }
}
