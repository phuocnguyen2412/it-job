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

    public static int handleDeleteCompanyReview(int companyReviewId){
        return CompanyReviewDAO.handleDeleteCompanyReview(companyReviewId);
    }

    public static CompanyReview getCompanyReviewById(int companyReviewId){
        return CompanyReviewDAO.getCompanyReviewById(companyReviewId);
    }

    public static ArrayList<CompanyReview> getCompanyReviewList(int companyId){
        return CompanyReviewDAO.getCompanyReviewList(companyId);
    }
}
