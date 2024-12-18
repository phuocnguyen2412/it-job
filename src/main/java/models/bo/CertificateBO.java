package models.bo;

import exception.BadRequestException;
import models.bean.Certificate;
import models.dao.CertificateDAO;

import java.util.ArrayList;

public class CertificateBO {
    CertificateDAO certificateDAO = new CertificateDAO();

    public Certificate mockData() {
        return new Certificate(1, "Java", "Oracle", java.sql.Timestamp.valueOf("2021-01-01 00:00:00"), "Java", "https://www.oracle.com/java", 1);
    }

    public ArrayList<Certificate> getCertificatesByUserId(int userId) {
        if (userId <= 0) {
            throw new BadRequestException("User ID không hợp lệ!");
        }

        return certificateDAO.getCertificatesByUserId(userId);
    }

    public boolean addCertificate(Certificate certificate) {
        validateCertificate(certificate);

        return certificateDAO.addCertificate(certificate);
    }

    public boolean updateCertificate(Certificate certificate) {
        if (certificate.getId() <= 0) {
            throw new BadRequestException("ID chứng chỉ không hợp lệ!");
        }

        validateCertificate(certificate);

        return certificateDAO.updateCertificate(certificate);
    }

    public boolean deleteCertificate(int certificateId) {
        if (certificateId <= 0) {
            throw new BadRequestException("ID chứng chỉ không hợp lệ!");
        }

        return certificateDAO.deleteCertificate(certificateId);
    }

    private void validateCertificate(Certificate certificate) {
        if (certificate.getName() == null || certificate.getName().isEmpty()) {
            throw new BadRequestException("Tên chứng chỉ không được để trống!");
        }
        if (certificate.getOrganization() == null || certificate.getOrganization().isEmpty()) {
            throw new BadRequestException("Tên tổ chức không được để trống!");
        }
        if (certificate.getDate() == null) {
            throw new BadRequestException("Ngày cấp không được để trống!");
        }
        if (certificate.getUserId() <= 0) {
            throw new BadRequestException("User ID không hợp lệ!");
        }
    }
}
