package models.bean;

import java.sql.Timestamp;

public class Education {
    private int id;
    private int userId;
    private String school;
    private String specialize;
    private Timestamp dateStart;
    private Timestamp dateEnd;

    public Education() {}

    public Education(int id, int userId, String school, String specialize, Timestamp dateStart, Timestamp dateEnd) {
        this.id = id;
        this.userId = userId;
        this.school = school;
        this.specialize = specialize;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
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
