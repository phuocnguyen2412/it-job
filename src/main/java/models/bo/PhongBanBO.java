package models.bo;

import models.bean.PhongBan;
import models.dao.PhongBanDAO;

import java.util.List;

public class PhongBanBO {
    public static List<PhongBan> getAllPhongBan() {
        return PhongBanDAO.getAllPhongBan();
    }

    public static void updatePhongBan(PhongBan phongBan) {
        PhongBanDAO.updatePhongBan(phongBan);
    }

    public static PhongBan getPhongBanById(String id) {
        return PhongBanDAO.getPhongBanById(id);
    }
}
