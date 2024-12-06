package models.bo;

import models.bean.NhanVien;
import models.dao.NhanVienDAO;

import java.util.ArrayList;
import java.util.List;

public class NhanVienBO {
    public static List<NhanVien> findNhanVien(String key, String value) {
        if (key.equals("IDNV")) {
            NhanVien nhanVien = new NhanVienDAO().getNhanVienById(value);
          
            return nhanVien == null ? new ArrayList<>() : new ArrayList<>() {{
                add(nhanVien);
            }};
        }
        return new NhanVienDAO().findNhanVien(key, value);
    }

    public static List<NhanVien> getAllNhanVien() {
        return new NhanVienDAO().getAllNhanVien();
    }

    public static NhanVien getNhanVienById(String id) {
        return new NhanVienDAO().getNhanVienById(id);
    }

    public static List<NhanVien> getAllNhanVienByPhongBan(String idPB) {
        return new NhanVienDAO().getAllNhanVienInPhongBan(idPB);
    }

    public static void createNhanVien(NhanVien nhanVien) {
        new NhanVienDAO().createNhanVien(nhanVien);
    }

    public static void updateNhanVien(NhanVien nhanVien) {
        new NhanVienDAO().updateNhanVien(nhanVien);
    }

    public static void deleteNhanVien(String id) {
        new NhanVienDAO().deleteNhanVien(id);
    }

    public static void deleteMultiNhanVien(String[] ids) {
        new NhanVienDAO().deleteMultiNhanVien(ids);
    }
}
