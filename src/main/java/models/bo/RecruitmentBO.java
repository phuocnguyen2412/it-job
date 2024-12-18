package models.bo;

import models.bean.Recruitment;
import models.dao.RecruitmentDAO;

public class RecruitmentBO {
    private RecruitmentDAO recruitmentDAO;
    
    public int handleCreateRecruitment(Recruitment recruitment) {
        return recruitmentDAO.handleCreateRecruitment(recruitment);
    }

    public int handleEditRecruitment(Recruitment recruitment) {
        return recruitmentDAO.handleEditRecruitment(recruitment);
    }

    public int handleDeleteRecruitment(int recruitmentId) {
        return recruitmentDAO.handleDeleteRecruitment(recruitmentId);
    }

    public Recruitment getRecruitment(int recruitmentId) {
        return recruitmentDAO.getRecruitmentById(recruitmentId);
    }
}
