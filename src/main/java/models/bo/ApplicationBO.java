package models.bo;

import models.bean.Application;

import models.bean.Application;
import models.dao.ApplicationDAO;

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

    public Application getAllApplication(int userId, int recruitmentId) {
        return applicationDAO.getAppication(userId, recruitmentId);
    }
}
