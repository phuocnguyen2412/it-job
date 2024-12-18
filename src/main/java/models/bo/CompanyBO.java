package models.bo;

import models.bean.Company;
import models.dao.CompanyDAO;

import java.util.ArrayList;

public class CompanyBO {
    private CompanyDAO companyDAO;

    public CompanyBO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public int handleCreateCompany(Company company) {
        return companyDAO.handleCreateCompany(company);
    }

    public int handleEditCompany(Company company) {
        return companyDAO.handleEditCompany(company);
    }

    public int handleDeleteCompany(int companyId) {
        return companyDAO.handleDeleteCompany(companyId);
    }

    public Company getCompanyById(int companyId) {
        return companyDAO.getCompanyById(companyId);
    }

    public ArrayList<Company> getCompanyList() {
        return companyDAO.getCompanyList();
    }

    public ArrayList<Company> searchCompany(String city, String inputSearch) {
        return companyDAO.searchCompany(city, inputSearch);
    }
}
