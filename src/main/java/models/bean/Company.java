package models.bean;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String introduce;
    private String country;
    private String industry;
    private String workingDays;
    private String size;
    private String detail;
    private String email;
    private String logo;
    private int accountId;
    private String Skills;

    public Company() {
    }

    public Company(int id, String name, String introduce, String country, String industry, String workingDays, String size, String detail, String email, String logo, int accountId) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.country = country;
        this.industry = industry;
        this.workingDays = workingDays;
        this.size = size;
        this.detail = detail;
        this.email = email;
        this.logo = logo;
        this.accountId = accountId;
    }

    public List<String> getSkills() {
        return List.of(Skills.split(","));
    }

    public void setSkills(String Skills) {
        this.Skills = Skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
