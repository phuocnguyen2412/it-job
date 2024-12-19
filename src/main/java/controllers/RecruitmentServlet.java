package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Recruitment;
import models.bo.RecruitmentBO;

import java.io.IOException;

@WebServlet(name = "RecruitmentServlet", urlPatterns = {"/recruitment/*"})
public class RecruitmentServlet extends BaseController {
    private RecruitmentBO recruimentBO;

    @Override
    public void init() throws ServletException {
        recruimentBO = new RecruitmentBO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/detail" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                Recruitment recruitment = recruimentBO.getRecruitmentById(id);
                req.setAttribute("recruitment", recruitment);
                render(req, resp, "/recruitment/detail");

            }

            default -> {
                render(req, resp, "/recruitment/index");
            }

        }
    }
}
