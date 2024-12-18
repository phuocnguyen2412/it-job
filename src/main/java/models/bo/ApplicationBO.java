package models.bo;

import models.bean.Application;

import models.bean.Application;
import models.bean.Certificate;
import models.dao.*;
import models.bean.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class ApplicationBO {
    public Application mockApplication() {
        Application application = new Application();
        application.setId(1);
        application.setCv("download");
        application.setStatus("PENDING");
        application.setRecruitmentId(1);
        application.setUserId(1);
        application.setUser(new UserBO().mockData());
        application.setRecruitment(new RecruitmentBO().mockRecruitment());
        return application;
    }
    ApplicationDAO applicationDAO = new ApplicationDAO();
    UserBO userBO = new UserBO();
    CertificateBO certificateBO = new CertificateBO();
    EducationBO educationBO = new EducationBO();
    RecruitmentBO recruitmentBO = new RecruitmentBO();
    CompanyBO companyBO = new CompanyBO();
    CompanyAddressBO companyAddressBO = new CompanyAddressBO();


    public Application getAllApplication(int userId, int recruitmentId) {
        return applicationDAO.getAppication(userId, recruitmentId);
    }
    public ArrayList<Application> getApplicationByUserId(int userId){
        ArrayList<Application> result = applicationDAO.getApplicationByUserId(userId);
        for(Application application : result){
            User user = userBO.getUserById(userId);
            ArrayList<Certificate> certificates = certificateBO.getCertificatesByUserId(userId);
            ArrayList<Education> educations = educationBO.getEducationByUserId(userId);
            user.setCertificates(certificates);
            user.setEducations(educations);
            application.setUser(user);

            Recruitment recruitment = recruitmentBO.getRecruitmentById(application.getRecruitmentId());
            Company company = companyBO.getCompanyById(recruitment.getCompanyId());
            ArrayList<CompanyAddress> companyAddresses = companyAddressBO.getCompanyAddress(recruitment.getCompanyId());
            recruitment.setAddresses(companyAddresses);
            recruitment.setCompany(company);
            application.setRecruitment(recruitment);
        }
        return  result;
    }
    public void handleCreateApplication(Application application){
        applicationDAO.apply(application);
    }
    public ArrayList<Application> getApplicationsByRecruimentId(int recruitmentId){
        return applicationDAO.getApplicationByRecruitmentId(recruitmentId);
    }
}
