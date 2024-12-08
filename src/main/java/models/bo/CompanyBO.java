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

    public static int handleDeleteCompany(int Id){
        return CompanyDAO.handleDeleteCompany(Id);
    }

    public static Company getCompanyById(int Id){
        return CompanyDAO.getCompanyById(Id);
    }

    public static ArrayList<Company> getCompanyList(){
        return CompanyDAO.getCompanyList();
    }
}
