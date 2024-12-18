package models.bo;

import models.bean.CompanyAddress;
import models.dao.RecruitmentAddressDAO;

import java.util.ArrayList;

public class RecruitmentAddressBO {
    private final RecruitmentAddressDAO recruitmentAddressDAO = new RecruitmentAddressDAO();

    public ArrayList<CompanyAddress> getCompanyAddress(int recruitmentId) {
        return recruitmentAddressDAO.getCompanyAddress(recruitmentId);
    }
}
