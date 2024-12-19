package models.bo;

import models.bean.Company;
import models.dao.CompanyDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyBO {
    CompanyDAO companyDAO = new CompanyDAO();
    public int handleCreateCompany(Company company) throws SQLException {
        return companyDAO.handleCreateCompany(company);
    }

    public int handleEditCompany(Company company) throws SQLException{
        return companyDAO.handleEditCompany(company);
    }

    public int handleDeleteCompany(int companyId) throws SQLException{
        return companyDAO.handleDeleteCompany(companyId);
    }

    public Company getCompanyById(int companyId) {
        return companyDAO.getCompanyById(companyId);
    }

    public ArrayList<Company> getCompanyList() {
        return companyDAO.getCompanyList();
    }

    public ArrayList<Company> searchCompany(String city, String inputSearch) throws SQLException{
        return companyDAO.searchCompany(city, inputSearch);
    }

    public Company getCompanyByAccountId(int accountId){
        return companyDAO.getCompanyByAccountId(accountId);
    }
    
}
