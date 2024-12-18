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
        switch (path) {
            case "/":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                String city = req.getParameter("city");

                List<Recruitment> recruitments = recruitmentBO.getRecruitmentBySearch(city, key, value);
                String recruitmentId = req.getParameter("recruitmentId");
                Recruitment recruitment;

                System.out.println(recruitmentId);
                if (recruitmentId != null) {

                    recruitment = recruitmentBO.getRecruitmentById(Integer.parseInt(recruitmentId.trim()));


                } else {
                    recruitment = recruitments.get(0);
                }
                System.out.println(recruitment);
                req.setAttribute("recruitments", recruitments);
                req.setAttribute("recruitment", recruitment);
                req.setAttribute("city", city);
                req.setAttribute("key", key);
                req.setAttribute("value", value);

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
        if (companyId == null) {
            throw new NotFoundException();
        }

        Company company = new CompanyBO().getCompanyById(Integer.parseInt(companyId));
        ArrayList<Recruitment> recruitments = recruitmentBO.getRecruitment();

        req.setAttribute("recruitments", recruitments);
        req.setAttribute("company", company);
        render(req, resp, "/company/detail");
    }
}
