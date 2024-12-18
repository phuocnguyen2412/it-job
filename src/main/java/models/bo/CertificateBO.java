package models.bo;

import models.bean.Certificate;
import models.dao.CertificateDAO;

import java.util.List;

public class CertificateBO {
    private CertificateDAO certificateDAO;

    public CertificateBO(CertificateDAO certificateDAO) {
        this.certificateDAO = certificateDAO;
    }

    public List<Certificate> getCertificatesByUserId(int userId) {
        return certificateDAO.getCertificatesByUserId(userId);
    }

    public boolean addCertificate(Certificate certificate) {
        return certificateDAO.addCertificate(certificate);
    }

    public boolean updateCertificate(Certificate certificate) {
        return certificateDAO.updateCertificate(certificate);

    }

    public boolean deleteCertificate(int certificateId) {
        return certificateDAO.deleteCertificate(certificateId);

    }

//    private void validateCertificate(Certificate certificate) {
//        if (certificate.getName() == null || certificate.getName().isEmpty()) {
//            throw new BadRequestException("Tên chứng chỉ không được để trống!");
//        }
//        if (certificate.getOrganization() == null || certificate.getOrganization().isEmpty()) {
//            throw new BadRequestException("Tên tổ chức không được để trống!");
//        }
//        if (certificate.getDate() == null) {
//            throw new BadRequestException("Ngày cấp không được để trống!");
//        }
//        if (certificate.getUserId() <= 0) {
//            throw new BadRequestException("User ID không hợp lệ!");
//        }
//    }
}
