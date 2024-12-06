package models.bean;

public class NhanVien {
    String IDNV;
    String HoTen;
    String IDPB;
    String DiaChi;


    public NhanVien(String diaChi, String IDPB, String hoTen, String IDNV) {
        this.DiaChi = diaChi;
        this.IDPB = IDPB;
        this.HoTen = hoTen;
        this.IDNV = IDNV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getIDNV() {
        return IDNV;
    }

    public String getIDPB() {
        return IDPB;
    }
}

