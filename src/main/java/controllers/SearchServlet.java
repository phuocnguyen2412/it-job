package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.bo.CompanyAddressBO;
import models.bo.CompanyBO;
import models.bo.RecruitmentBO;
import models.dao.RecruitmentDAO;

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

                if (recruitmentId != null) {
                    recruitment = recruitmentBO.getRecruitmentById(Integer.parseInt(recruitmentId));
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
        if (companyId == null) {
            throw new NotFoundException();
        }

        Company company = new CompanyBO().getCompanyById(Integer.parseInt(companyId));
//        Recruitment recruitment = new Recruitment();
//        recruitment.setPosition("Java Developer");
//        recruitment.setJobDescription("Develop software applications using Java programming language");
//        recruitment.setRequirement("At least 1 year of experience in Java programming");
//        recruitment.setRangeOfSalaryFrom(1000);
//        recruitment.setRangeOfSalaryTo(2000);
//        recruitment.setSkills("java,c++,c#,python,javascript");
//        recruitment.setBenefit("13th month salary, health insurance, annual leave");
//        recruitment.setAddresses(new ArrayList<>() {
//            {
//                add(new CompanyAddressBO().mockAdress());
//                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
//            }
//        });
//
//        ArrayList<Recruitment> recruitments = new ArrayList<>() {
//            {
//                add(recruitment);
//                add(recruitment);
//                add(recruitment);
//            }
//        };

        ArrayList<Recruitment> recruitments = recruitmentBO.getRecruitment();

        req.setAttribute("recruitments", recruitments);
        req.setAttribute("company", company);
        render(req, resp, "/company/detail");
    }
}
