package models.bean;

import java.sql.Timestamp;

public class Experience {
    private int id;
    private String company;
    private int userId;
    private String position;
    private String detail;
    private Timestamp dateStart;
    private Timestamp dateEnd;

    public Experience() {}

    public Experience(int id, String company, int userId, String position, String detail, Timestamp dateStart, Timestamp dateEnd) {
        this.id = id;
        this.company = company;
        this.userId = userId;
        this.position = position;
        this.detail = detail;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }
}
