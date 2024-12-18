package models.bo;

import models.bean.Application;

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
}
