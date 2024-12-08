package models.bo;

import models.bean.Recruitment;
import models.dao.RecruitmentDAO;

public class RecruitmentBO {
    public static int handleCreateRecruitment(Recruitment recruitment){
        return RecruitmentDAO.handleCreateRecruitment(recruitment);
    }

    public static int handleEditRecruitment(Recruitment recruitment){
        return RecruitmentDAO.handleEditRecruitment(recruitment);
    }

    public static int handleDeleteRecruitment(int recruitmentId){
        return RecruitmentDAO.handleDeleteRecruitment(recruitmentId);
    }

    public static Recruitment getRecruitment(int recruitmentId){
        return RecruitmentDAO.getRecruitmentById(recruitmentId);
    }
}
