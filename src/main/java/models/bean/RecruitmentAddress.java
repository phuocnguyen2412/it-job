package models.bean;

public class RecruitmentAddress {
    private int id;
    private int addressId;
    private int recruitmentId;

    public RecruitmentAddress() {}

    public RecruitmentAddress(int id, int addressId, int recruitmentId) {
        this.id = id;
        this.addressId = addressId;
        this.recruitmentId = recruitmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }
}
