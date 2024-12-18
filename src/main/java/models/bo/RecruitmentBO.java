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

    public List<Recruitment> mockRecruitments() {
        List<Recruitment> recruitments = new ArrayList<>();

        // Đơn ứng tuyển 1
        Recruitment recruitment1 = new Recruitment();
        recruitment1.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis() - 3600000)); // 1 giờ trước

        recruitment1.setPosition("Java Developer");
        recruitment1.setJobDescription("Develop software applications using Java programming language");
        recruitment1.setRequirement("At least 1 year of experience in Java programming");
        recruitment1.setRangeOfSalaryFrom(1000);
        recruitment1.setRangeOfSalaryTo(2000);
        recruitment1.setSkills("java,c++,c#,python,javascript");
        recruitment1.setBenefit("13th month salary, health insurance, annual leave");
        recruitment1.setCompany(new CompanyBO().mockCompany());
        recruitment1.setAddresses(new ArrayList<CompanyAddress>() {
            {
                add(new CompanyAddressBO().mockAdress());
            }
        });
        recruitments.add(recruitment1);

        // Đơn ứng tuyển 2
        Recruitment recruitment2 = new Recruitment();
        recruitment2.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis() - 86400000));
        recruitment2.setPosition("Python Developer");
        recruitment2.setJobDescription("Develop and maintain Python-based applications");
        recruitment2.setRequirement("At least 2 years of experience in Python development");
        recruitment2.setRangeOfSalaryFrom(1200);
        recruitment2.setRangeOfSalaryTo(2500);
        recruitment2.setSkills("python,django,flask,sql,html");
        recruitment2.setBenefit("Flexible working hours, health insurance, gym membership");
        recruitment2.setCompany(new CompanyBO().mockCompany());
        recruitment2.setAddresses(new ArrayList<CompanyAddress>() {
            {
                add(new CompanyAddressBO().mockAdress());
                add(new CompanyAddressBO().mockAdress());
            }
        });
        recruitments.add(recruitment2);

        // Đơn ứng tuyển 3
        Recruitment recruitment3 = new Recruitment();
        recruitment3.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis() - 2592000000L)); // 30 ngày trước
        recruitment3.setPosition("Frontend Developer");
        recruitment3.setJobDescription("Build responsive web interfaces using modern frontend frameworks");
        recruitment3.setRequirement("At least 3 years of experience in frontend development");
        recruitment3.setRangeOfSalaryFrom(1500);
        recruitment3.setRangeOfSalaryTo(3000);
        recruitment3.setSkills("javascript,react,vue,html,css");
        recruitment3.setBenefit("Stock options, remote work opportunities, free meals");
        recruitment3.setCompany(new CompanyBO().mockCompany());
        recruitment3.setAddresses(new ArrayList<CompanyAddress>() {
            {
                add(new CompanyAddressBO().mockAdress());
                add(new CompanyAddressBO().mockAdress());
                add(new CompanyAddressBO().mockAdress());
            }
        });
        recruitments.add(recruitment3);

        return recruitments;
    }

    public Recruitment mockRecruitment() {
        Recruitment recruitment = new Recruitment();
        recruitment.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis() - 80000));
        recruitment.setPosition("Java Developer");
        recruitment.setJobDescription("Develop software applications using Java programming language");
        recruitment.setRequirement("At least 1 year of experience in Java programming");
        recruitment.setRangeOfSalaryFrom(1000);
        recruitment.setRangeOfSalaryTo(2000);
        recruitment.setSkills("java,c++,c#,python,javascript");
        recruitment.setBenefit("13th month salary, health insurance, annual leave");
        recruitment.setCompany(new CompanyBO().mockCompany());
        recruitment.setAddresses(new CompanyAddressBO().mockAdresses());
        return recruitment;
    }
}
