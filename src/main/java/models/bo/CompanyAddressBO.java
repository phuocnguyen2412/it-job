package models.bo;

import models.bean.CompanyAddress;
import models.dao.CompanyAddressDAO;

import java.util.ArrayList;

public class CompanyAddressBO {
    private CompanyAddressDAO companyAddressDAO;

    public CompanyAddressBO(CompanyAddressDAO companyAddressDAO) {
        this.companyAddressDAO = companyAddressDAO;
    }

    public int handleCreateCompanyAddress(CompanyAddress companyAddress) {
        return companyAddressDAO.handleCreateCompanyAddress(companyAddress);
    }

    public int handleEditCompanyAddress(CompanyAddress companyAddress) {
        return companyAddressDAO.handleEditCompanyAddress(companyAddress);
    }

    public int handleDeleteCompanyAddress(int companyAddressId) {
        return companyAddressDAO.handleDeleteCompanyAddress(companyAddressId);
    }

    public ArrayList<CompanyAddress> getCompanyAddress(int companyId) {
        return companyAddressDAO.getCompanyAddress(companyId);
    }
}
