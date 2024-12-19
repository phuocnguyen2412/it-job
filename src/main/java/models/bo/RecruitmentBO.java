package models.bo;

import models.bean.Company;
import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.dao.RecruitmentDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecruitmentBO {
    RecruitmentDAO recruitmentDAO = new RecruitmentDAO();
    CompanyBO companyBO = new CompanyBO();
    RecruitmentAddressBO recruitmentAddressBO = new RecruitmentAddressBO();


    public void handleCreateRecruitment(Recruitment recruitment) {

        recruitmentDAO.handleCreateRecruitment(recruitment);
    }

    public int handleEditRecruitment(Recruitment recruitment) throws SQLException {
        return recruitmentDAO.handleEditRecruitment(recruitment);
    }

    public int handleDeleteRecruitment(int recruitmentId) throws SQLException {
        return recruitmentDAO.handleDeleteRecruitment(recruitmentId);
    }

    public Recruitment getRecruitmentById(int recruitmentId) {
       
        Recruitment recruitment = recruitmentDAO.getRecruitmentById(recruitmentId);
        System.out.println(recruitment);
        Company company = companyBO.getCompanyById(recruitment.getCompanyId());
        ArrayList<CompanyAddress> companyAddresses = recruitmentAddressBO.getCompanyAddress(recruitment.getCompanyId());
        recruitment.setCompany(company);
        recruitment.setAddresses(companyAddresses);
        return recruitment;
    }

    public ArrayList<Recruitment> getRecruitmentBySearch(String country, String searchBy, String searchInput) {
        return recruitmentDAO.getRecruitmentBySearch(country, searchBy, searchInput);
    }

    public ArrayList<Recruitment> getRecruitmentsByCompanyId(int companyId){
        return recruitmentDAO.getRecruitmentByCompanyId(companyId);
    }

    public ArrayList<Recruitment> getRecruitment() {
        return recruitmentDAO.getRecruitment();
    }

}
