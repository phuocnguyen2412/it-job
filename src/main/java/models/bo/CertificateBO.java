package models.bo;

import exception.BadRequestException;
import models.bean.Certificate;
import models.dao.CertificateDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CertificateBO {
    private final CertificateDAO certificateDAO;

    public CertificateBO(Connection connection) {
        this.certificateDAO = new CertificateDAO(connection);
    }

    public List<Certificate> getCertificatesByUserId(int userId) {
        if (userId <= 0) {
            throw new BadRequestException("User ID không hợp lệ!");
        }

        try {
            return certificateDAO.getCertificatesByUserId(userId);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi lấy danh sách chứng chỉ cho user ID: " + userId, e);
        }
    }

    public boolean addCertificate(Certificate certificate) {
        validateCertificate(certificate);

        try {
            return certificateDAO.addCertificate(certificate);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi thêm chứng chỉ mới", e);
        }
    }

    public boolean updateCertificate(Certificate certificate) {
        if (certificate.getId() <= 0) {
            throw new BadRequestException("ID chứng chỉ không hợp lệ!");
        }

        validateCertificate(certificate);

        try {
            return certificateDAO.updateCertificate(certificate);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi cập nhật chứng chỉ", e);
        }
    }

    public boolean deleteCertificate(int certificateId) {
        if (certificateId <= 0) {
            throw new BadRequestException("ID chứng chỉ không hợp lệ!");
        }

        try {
            return certificateDAO.deleteCertificate(certificateId);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi xóa chứng chỉ với ID: " + certificateId, e);
        }
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
