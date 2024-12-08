package models.bean;

public class Certificate {
    private int id;
    private String name;
    private String organization;
    private java.sql.Timestamp date;
    private String detail;
    private String link;
    private int userId;

    public Certificate() {}

    public Certificate(int id, String name, String organization, java.sql.Timestamp date, String detail, String link, int userId) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.date = date;
        this.detail = detail;
        this.link = link;
        this.userId = userId;
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public java.sql.Timestamp getDate() {
        return date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
