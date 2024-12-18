package models.bo;

import models.bean.Company;
import models.dao.CompanyDAO;

import java.util.ArrayList;

public class CompanyBO {
    public static int handleCreateCompany(Company company) {
        return CompanyDAO.handleCreateCompany(company);
    }

    public static int handleEditCompany(Company company) {
        return CompanyDAO.handleEditCompany(company);
    }

    public static int handleDeleteCompany(int companyId) {
        return CompanyDAO.handleDeleteCompany(companyId);
    }

    public static Company getCompanyById(int companyId) {
        return CompanyDAO.getCompanyById(companyId);
    }

    public static ArrayList<Company> getCompanyList() {
        return CompanyDAO.getCompanyList();
    }

    public static ArrayList<Company> searchCompany(String city, String inputSearch) {
        return CompanyDAO.searchCompany(city, inputSearch);
    }

    public Company mockCompany() {
        Company company = new Company();
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
