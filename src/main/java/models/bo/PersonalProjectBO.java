package models.bo;

import exception.BadRequestException;
import models.bean.PersonalProject;
import models.dao.PersonalProjectDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonalProjectBO {
    private final PersonalProjectDAO personalProjectDAO;

    public PersonalProjectBO(Connection connection) {
        this.personalProjectDAO = new PersonalProjectDAO(connection);
    }

    public List<PersonalProject> getProjectsByUserId(int userId) {
        if (userId <= 0) {
            throw new BadRequestException("User ID không hợp lệ!");
        }

        try {
            return personalProjectDAO.getProjectsByUserId(userId);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi lấy danh sách dự án của người dùng: " + userId, e);
        }
    }

    public boolean addProject(PersonalProject project) {
        validateProject(project);

        try {
            return personalProjectDAO.addProject(project);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi thêm dự án mới", e);
        }
    }

    public boolean updateProject(PersonalProject project) {
        if (project.getId() <= 0) {
            throw new BadRequestException("ID dự án không hợp lệ!");
        }

        validateProject(project);

        try {
            return personalProjectDAO.updateProject(project);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi cập nhật dự án", e);
        }
    }

    public boolean deleteProject(int projectId) {
        if (projectId <= 0) {
            throw new BadRequestException("ID dự án không hợp lệ!");
        }

        try {
            return personalProjectDAO.deleteProject(projectId);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi xóa dự án với ID: " + projectId, e);
        }
    }

    private void validateProject(PersonalProject project) {
        if (project.getName() == null || project.getName().isEmpty()) {
            throw new BadRequestException("Tên dự án không được để trống!");
        }
        if (project.getDateStart() == null) {
            throw new BadRequestException("Ngày bắt đầu không được để trống!");
        }
        if (project.getDateEnd() != null && project.getDateStart().after(project.getDateEnd())) {
            throw new BadRequestException("Ngày bắt đầu không được sau ngày kết thúc!");
        }
        if (project.getUserId() <= 0) {
            throw new BadRequestException("User ID không hợp lệ!");
        }
    }
}
