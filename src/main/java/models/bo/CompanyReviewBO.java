package models.bo;

import models.bean.CompanyReview;
import models.dao.CompanyReviewDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyReviewBO {
    CompanyReviewDAO companyReviewDAO = new CompanyReviewDAO();
    public int handleCreateCompanyReview(CompanyReview companyReview) throws SQLException {
        return companyReviewDAO.handleCreateCompanyReview(companyReview);
    }

    public int handleEditCompanyReview(CompanyReview companyReview) throws SQLException{
        return companyReviewDAO.handleEditCompanyReview(companyReview);
    }

    public int handleDeleteCompanyReview(int companyReviewId) throws SQLException{
        return companyReviewDAO.handleDeleteCompanyReview(companyReviewId);
    }

    public CompanyReview getCompanyReviewById(int companyReviewId) throws SQLException{
        return companyReviewDAO.getCompanyReviewById(companyReviewId);
    }

    public ArrayList<CompanyReview> getCompanyReviewList(int companyId) throws SQLException{
        return companyReviewDAO.getCompanyReviewList(companyId);
    }
}
