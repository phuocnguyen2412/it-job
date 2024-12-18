package models.bean;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String introduce;
    private String email;
    private String phoneNumber;
    private java.sql.Date birthday;
    private String city;
    private byte[] avatar;
    private int accountId;
    private List<PersonalProject> projects;
    private List<Experience> experiences;
    private List<Education> educations;
    private String skills;
    private List<Certificate> certificates;

    public User() {
    }

    public User(int id, String name, String introduce, String email, String phoneNumber, java.sql.Date birthday, String city, byte[] avatar, int accountId) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.city = city;
        this.avatar = avatar;
        this.accountId = accountId;
    }

    public List<PersonalProject> getProjects() {
        return projects;
    }

    public void setProjects(List<PersonalProject> projects) {
        this.projects = projects;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
