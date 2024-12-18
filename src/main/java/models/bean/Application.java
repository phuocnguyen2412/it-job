package models.bean;

public class Application {
    private int id;
    private int userId;
    private int recruitmentId;
    private String cv;
    private String status;

    public Application() {
    }

    public Application(int id, int userId, int recruitmentId, String cv, String status) {
        this.id = id;
        this.userId = userId;
        this.recruitmentId = recruitmentId;
        this.cv = cv;
        this.status = status;
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

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
