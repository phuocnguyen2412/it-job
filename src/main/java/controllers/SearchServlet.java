package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.Recruitment;
import models.bo.CompanyBO;
import models.bo.RecruitmentBO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search/*"})
public class SearchServlet extends BaseController {
    private RecruitmentBO recruitmentBO;

    @Override
    public void init() throws ServletException {
        recruitmentBO = new RecruitmentBO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        System.out.println(path);
        switch (path) {
            case "/":
                List<Recruitment> recruitments = new ArrayList<>() {
                    {
                        add(recruitmentBO.mockRecruitment());
                        add(recruitmentBO.mockRecruitment());
                        add(recruitmentBO.mockRecruitment());
                        add(recruitmentBO.mockRecruitment());
                    }
                };

                String recruitmentId = req.getParameter("recruitmentId");
                Recruitment recruitment;

                if (recruitmentId != null) {
                    recruitment = recruitmentBO.mockRecruitment();
                    recruitment.setId(Integer.parseInt(recruitmentId));
                    req.setAttribute("recruitment", recruitment);
                } else {
                    recruitment = recruitments.get(0);
                }

                req.setAttribute("recruitments", recruitments);
                req.setAttribute("recruitment", recruitment);
                render(req, resp, "/search");
                break;
            case "/company/detail":
                get_detail(req, resp);
                break;
            default:
                render(req, resp, "/search");
                break;
        }
    }

    private void get_detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyId = req.getParameter("id");
        System.out.println(companyId);
        if (companyId == null) {
            throw new NotFoundException();
        }
        Company company = new CompanyBO().mockCompany();

        List<Recruitment> recruitments = new RecruitmentBO().mockRecruitments();
        req.setAttribute("recruitments", recruitments);
        req.setAttribute("company", company);
        render(req, resp, "/company/detail");
    }
}
