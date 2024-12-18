package models.bo;

import models.bean.PersonalProject;
import models.dao.PersonalProjectDAO;

import java.util.ArrayList;
import java.util.List;

public class PersonalProjectBO {
    PersonalProjectDAO personalProjectDAO = new PersonalProjectDAO();

    public ArrayList<PersonalProject> getProjectsByUserId(int userId) {
        return personalProjectDAO.getProjectsByUserId(userId);
    }

    public boolean addProject(PersonalProject project) {
        return personalProjectDAO.addProject(project);
    }

    public boolean updateProject(PersonalProject project) {
        return personalProjectDAO.updateProject(project);
    }


    public boolean deleteProject(int projectId) {
        return personalProjectDAO.deleteProject(projectId);
    }

//    private void validateProject(PersonalProject project) {
//        if (project.getName() == null || project.getName().isEmpty()) {
//            throw new BadRequestException("Tên dự án không được để trống!");
//        }
//        if (project.getDateStart() == null) {
//            throw new BadRequestException("Ngày bắt đầu không được để trống!");
//        }
//        if (project.getDateEnd() != null && project.getDateStart().after(project.getDateEnd())) {
//            throw new BadRequestException("Ngày bắt đầu không được sau ngày kết thúc!");
//        }
//        if (project.getUserId() <= 0) {
//            throw new BadRequestException("User ID không hợp lệ!");
//        }
//    }
}
