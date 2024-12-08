package models.bo;

import models.bean.CompanyReview;
import models.dao.CompanyReviewDAO;

import java.util.ArrayList;

public class CompanyReviewBO {
    public static int handleCreateCompanyReview(CompanyReview companyReview){
        return CompanyReviewDAO.handleCreateCompanyReview(companyReview);
    }

    public static int handleEditCompanyReview(CompanyReview companyReview){
        return CompanyReviewDAO.handleEditCompanyReview(companyReview);
    }

    public static int handleDeleteCompanyReview(int Id){
        return CompanyReviewDAO.handleDeleteCompanyReview(Id);
    }

    public static CompanyReview getCompanyReviewById(int Id){
        return CompanyReviewDAO.getCompanyReviewById(Id);
    }

    public static ArrayList<CompanyReview> getCompanyReviewList(int companyId){
        return CompanyReviewDAO.getCompanyReviewList(companyId);
    }
}
