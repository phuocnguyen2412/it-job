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

    public int handleEditCompany(Company company) throws SQLException {
        return companyDAO.handleEditCompany(company);
    }

    public int handleDeleteCompany(int companyId) throws SQLException {
        return companyDAO.handleDeleteCompany(companyId);
    }

    public Company getCompanyById(int companyId) throws SQLException {
        return companyDAO.getCompanyById(companyId);
    }

    public ArrayList<Company> getCompanyList() throws SQLException {
        return companyDAO.getCompanyList();
    }

    public ArrayList<Company> searchCompany(String city, String inputSearch) throws SQLException {
        return companyDAO.searchCompany(city, inputSearch);
    }

    public Company mockCompany() {
        Company company = new Company();
        company.setCountry("Vietnam");
        company.setName("FPT Software");
        company.setEmail("Huynhphuocnguyen@gmail.com");
        company.setIndustry("Software Development Outsourcing");
        company.setSize("1000-5000");
        company.setWorkingDays("Mon-Fri");
        company.setIntroduce("FPT Software is a global company with offices in 52 countries. With 20 years of experience in the technology industry, we have a team of more than 10,000 professionals working in 33 countries. We provide world-class software development services in the areas of digital transformation, cloud computing, AI, IoT, and more.");
        company.setLogo("https://rubicmarketing.com/wp-content/uploads/2022/07/y-nghia-logo-fpt-lan-3.jpg");
        company.setSkills("java, c++, c#, python, javascript");
        return company;
    }
}
