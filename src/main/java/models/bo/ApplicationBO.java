package models.bo;

import models.bean.Application;
import models.dao.ApplicationDAO;

public class ApplicationBO {
    ApplicationDAO applicationDAO = new ApplicationDAO();

    public Application getAllApplication(int userId, int recruitmentId) {
        return applicationDAO.getAppication(userId, recruitmentId);
    }
}
