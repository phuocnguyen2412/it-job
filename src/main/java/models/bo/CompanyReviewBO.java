package models.bo;

import models.bean.CompanyReview;
import models.dao.CompanyReviewDAO;

import java.util.ArrayList;

public class CompanyReviewBO {
    private CompanyReviewDAO companyReviewDAO;

    public CompanyReviewBO(CompanyReviewDAO companyReviewDAO) {
        this.companyReviewDAO = companyReviewDAO;
    }

    public int handleCreateCompanyReview(CompanyReview companyReview) {
        return companyReviewDAO.handleCreateCompanyReview(companyReview);
    }

    public int handleEditCompanyReview(CompanyReview companyReview) {
        return companyReviewDAO.handleEditCompanyReview(companyReview);
    }

    public int handleDeleteCompanyReview(int companyReviewId) {
        return companyReviewDAO.handleDeleteCompanyReview(companyReviewId);
    }

    public CompanyReview getCompanyReviewById(int companyReviewId) {
        return companyReviewDAO.getCompanyReviewById(companyReviewId);
    }

    public ArrayList<CompanyReview> getCompanyReviewList(int companyId) {
        return companyReviewDAO.getCompanyReviewList(companyId);
    }
}
