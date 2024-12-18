package models.bo;

import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.dao.RecruitmentDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentBO {
    RecruitmentDAO recruitmentDAO = new RecruitmentDAO();

    public int handleCreateRecruitment(Recruitment recruitment) throws SQLException {
        return recruitmentDAO.handleCreateRecruitment(recruitment);
    }

    public int handleEditRecruitment(Recruitment recruitment) throws SQLException {
        return recruitmentDAO.handleEditRecruitment(recruitment);
    }

    public int handleDeleteRecruitment(int recruitmentId) throws SQLException {
        return recruitmentDAO.handleDeleteRecruitment(recruitmentId);
    }

    public Recruitment getRecruitment(int recruitmentId) throws SQLException {
        return recruitmentDAO.getRecruitmentById(recruitmentId);
    }

    public ArrayList<Recruitment> getRecruitment(String country, String searchBy, String searchInput) {
        return recruitmentDAO.getRecruitment(country, searchBy, searchInput);
    }

    public Recruitment mockRecruitment() {
        Recruitment recruitment = new Recruitment();
        recruitment.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        recruitment.setPosition("Java Developer");
        recruitment.setJobDescription("Develop software applications using Java programming language");
        recruitment.setRequirement("At least 1 year of experience in Java programming");
        recruitment.setRangeOfSalaryFrom(1000);
        recruitment.setRangeOfSalaryTo(2000);
        recruitment.setSkills("java,c++,c#,python,javascript");
        recruitment.setBenefit("13th month salary, health insurance, annual leave");
        recruitment.setCompany(new CompanyBO().mockCompany());
        recruitment.setAddresses(new ArrayList<CompanyAddress>() {
            {
                add(new CompanyAddressBO().mockAdress());
                add(new CompanyAddressBO().mockAdress());
                add(new CompanyAddressBO().mockAdress());
            }
        });
        return recruitment;
    }

    public List<Recruitment> mockRecruitments() {
        return new ArrayList<>();
    }
}
