package models.bean;

import java.util.List;

public class Recruitment {
    private int id;
    private String position;
    private int rangeOfSalaryFrom;
    private int rangeOfSalaryTo;
    private int companyId;
    private java.sql.Timestamp createdAt;
    private String requirement;
    private String benefit;
    private String jobDescription;
    private List<CompanyAddress> addresses;
    private String skills;

    public Recruitment() {
    }

    public Recruitment(int id, String position, int rangeOfSalaryFrom, int rangeOfSalaryTo, int companyId, java.sql.Timestamp createdAt, String requirement, String benefit, String jobDescription) {
        this.id = id;
        this.position = position;
        this.rangeOfSalaryFrom = rangeOfSalaryFrom;
        this.rangeOfSalaryTo = rangeOfSalaryTo;
        this.companyId = companyId;
        this.createdAt = createdAt;
        this.requirement = requirement;
        this.benefit = benefit;
        this.jobDescription = jobDescription;
    }

    public List<String> getSkills() {
        return List.of(skills.split(","));
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSalarayRange() {
        return this.rangeOfSalaryFrom + " - " + this.rangeOfSalaryTo + " USD";
    }

    public List<CompanyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CompanyAddress> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRangeOfSalaryFrom() {
        return rangeOfSalaryFrom;
    }

    public void setRangeOfSalaryFrom(int rangeOfSalaryFrom) {
        this.rangeOfSalaryFrom = rangeOfSalaryFrom;
    }

    public int getRangeOfSalaryTo() {
        return rangeOfSalaryTo;
    }

    public void setRangeOfSalaryTo(int rangeOfSalaryTo) {
        this.rangeOfSalaryTo = rangeOfSalaryTo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public List<String> getAllBenefits() {
        return List.of(benefit.split(","));
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
