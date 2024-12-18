package models.bo;

import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.dao.RecruitmentDAO;

import java.util.ArrayList;

public class RecruitmentBO {
    public static int handleCreateRecruitment(Recruitment recruitment) {
        return RecruitmentDAO.handleCreateRecruitment(recruitment);
    }

    public static int handleEditRecruitment(Recruitment recruitment) {
        return RecruitmentDAO.handleEditRecruitment(recruitment);
    }

    public static int handleDeleteRecruitment(int recruitmentId) {
        return RecruitmentDAO.handleDeleteRecruitment(recruitmentId);
    }

    public static Recruitment getRecruitment(int recruitmentId) {
        return RecruitmentDAO.getRecruitmentById(recruitmentId);
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
}
