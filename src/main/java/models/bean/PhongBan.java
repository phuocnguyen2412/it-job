package models.bean;

public class PhongBan {
    String IDPB;
    String TenPB;
    String MoTa;

    public PhongBan(String IDPB, String tenPB, String moTa) {
        this.IDPB = IDPB;
        this.TenPB = tenPB;
        this.MoTa = moTa;
    }

    public String getMoTa() {
        return MoTa;
    }

    public String getTenPB() {
        return TenPB;
    }

    public String getIDPB() {
        return IDPB;
    }

}
