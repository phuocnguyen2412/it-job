package models.bo;

import models.bean.*;
import models.dao.CompanyDAO;

import java.util.ArrayList;

public class CompanyBO {
    public static int handleCreateCompany(Company company){
        return CompanyDAO.handleCreateCompany(company);
    }

    public static int handleEditCompany(Company company){
        return CompanyDAO.handleEditCompany(company);
    }

    public static int handleDeleteCompany(int companyId){
        return CompanyDAO.handleDeleteCompany(companyId);
    }

    public static Company getCompanyById(int companyId){
        return CompanyDAO.getCompanyById(companyId);
    }

    public static ArrayList<Company> getCompanyList(){
        return CompanyDAO.getCompanyList();
    }
}
