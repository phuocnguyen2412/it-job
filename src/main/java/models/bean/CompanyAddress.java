package models.bean;

public class CompanyAddress {
    private int id;
    private int companyId;
    private String address;
    private String detail;

    public CompanyAddress() {}

    public CompanyAddress(int id, int companyId, String address, String detail) {
        this.id = id;
        this.companyId = companyId;
        this.address = address;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
