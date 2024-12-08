package models.bean;

import java.sql.Timestamp;

public class CompanyReview {
    private int id;
    private int userId;
    private String detail;
    private int point;
    private Timestamp createdAt;
    private int companyId;

    public CompanyReview() {}

    public CompanyReview(int id, int userId, String detail, int point, Timestamp createdAt, int companyId) {
        this.id = id;
        this.userId = userId;
        this.detail = detail;
        this.point = point;
        this.createdAt = createdAt;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
