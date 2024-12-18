package models.test;

import config.Database;
import models.dao.RecruitmentDAO;

import java.sql.Connection;

public class testDAO {
    public static void main(String[] args) {
        RecruitmentDAO recruitmentDAO = new RecruitmentDAO();
        System.out.println(recruitmentDAO.getRecruitmentById(14));
    }
}
