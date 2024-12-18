package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Application;
import models.bean.Company;
import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.bo.ApplicationBO;
import models.bo.CompanyAddressBO;
import models.bo.CompanyBO;
import models.bo.RecruitmentBO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CompanyServlet", urlPatterns = {"/company/*"})
public class CompanyServlet extends BaseController {
    private RecruitmentBO recruitmentBO;
    private CompanyAddressBO companyAddressBO;
    private ApplicationBO applicationBO;
    private CompanyBO companyBO;

    @Override
    public void init() throws ServletException {
        companyBO = new CompanyBO();
        companyAddressBO = new CompanyAddressBO();
        recruitmentBO = new RecruitmentBO();
        applicationBO = new ApplicationBO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        System.out.println(path);
        switch (path) {
            case "/create-recruitment":
                get_create_recruitment(req, resp);
                break;
            case "/edit-recruitment":
                get_edit_recruitment(req, resp);
                break;
            case "/edit":
                get_edit(req, resp);
                break;
            case "/list-recruitment":
                get_list_recruitment(req, resp);
                break;
            case "/list-application":
                get_list_application(req, resp);
                break;
            default:
                System.out.println("Not found");
                throw new NotFoundException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();

        switch (path) {

            case "/create-recruitment":
                post_create_recruitment(req, resp);
                break;
            case "/edit-recruitment":
                post_edit_recruitment(req, resp);
                break;
            case "/edit":
                post_edit(req, resp);

                break;
            default:
                System.out.println("Not found");
                throw new NotFoundException();
        }
    }

    private void get_list_application(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Application> applications = applicationBO.getApplicationsByRecruimentId((int) req.getSession().getAttribute("recruitment_id"));
        req.setAttribute("applications", applications);
        render(req, resp, "/company/recruitment/list-application", "template");
    }

    private void get_list_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Recruitment> recruitments = new ArrayList<>() {
            {
                add(recruitmentBO.mockRecruitment());
                add(recruitmentBO.mockRecruitment());
                add(recruitmentBO.mockRecruitment());
                add(recruitmentBO.mockRecruitment());
            }
        };
        req.setAttribute("recruitments", recruitments);
        render(req, resp, "/company/recruitment/list", "template");
    }

    private void get_create_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CompanyAddress> addresses = new ArrayList<>() {
            {
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
            }
        };
        req.setAttribute("addresses", addresses);
        render(req, resp, "/company/recruitment/create", "template");
    }

    private Recruitment getRecruitment(HttpServletRequest req) {
        Recruitment recruitment = new Recruitment();
        recruitment.setPosition(req.getParameter("position"));
        recruitment.setJobDescription(req.getParameter("jobDescription"));
        recruitment.setRequirement(req.getParameter("requirement"));
        recruitment.setRangeOfSalaryFrom(Integer.parseInt(req.getParameter("rangeOfSalaryFrom")));
        recruitment.setRangeOfSalaryTo(Integer.parseInt(req.getParameter("rangeOfSalaryTo")));
        recruitment.setSkills(req.getParameter("skills"));
        recruitment.setBenefit(req.getParameter("benefit"));
        return recruitment;
    }

    private void get_edit_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int recruitmentId = Integer.parseInt(req.getParameter("recruitment_id"));
        Recruitment recruitment = recruitmentBO.getRecruitmentById(recruitmentId);
        List<CompanyAddress> companyAddresses = new ArrayList<CompanyAddress>() {
            {
                add(companyAddressBO.mockAdress());
                add(companyAddressBO.mockAdress());
                add(companyAddressBO.mockAdress());
            }
        };
        req.setAttribute("companyAddresses", companyAddresses);
        req.setAttribute("recruitment", recruitment);
        render(req, resp, "/company/recruitment/edit", "template");
    }

    private void post_edit_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Recruitment recruitment = getRecruitment(req);
        String[] selectedAddresses = req.getParameterValues("addresses");
        System.out.println(recruitment);
        render(req, resp, "/company/recruitment/edit", "template");
    }

    private void post_edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = new Company();
        company.setId((int) req.getSession().getAttribute("companyId"));
        company.setName(req.getParameter("name"));
        company.setEmail(req.getParameter("email"));
        company.setIndustry(req.getParameter("industry"));
        company.setSize(req.getParameter("size"));
        company.setWorkingDays(req.getParameter("workingDays"));
        company.setIntroduce(req.getParameter("introduce"));
        company.setLogo(req.getParameter("logo"));
        company.setSkills(req.getParameter("skills"));
        req.setAttribute("company", company);
        System.out.println(company);
        render(req, resp, "/company/edit", "template");
    }

    private void get_edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int CompanyId = (int) req.getSession().getAttribute("companyId");
        Company company = companyBO.getCompanyById(CompanyId);
        req.setAttribute("company", company);
        render(req, resp, "/company/edit", "template");

    }

    private void post_create_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Recruitment recruitment = getRecruitment(req);
        int CompanyId = (int) req.getSession().getAttribute("companyId");
        String[] selectedAddressIds = req.getParameterValues("selectedAddresses");
        List<Integer> selectedAddresses = new ArrayList<>();
        if (selectedAddressIds != null) {
            for (String id : selectedAddressIds) {
                int addressId = Integer.parseInt(id);
                selectedAddresses.add(addressId);
            }
        }
        System.out.println(selectedAddresses);
        System.out.println(recruitment);
        recruitmentBO.handleCreateRecruitment(recruitment);
        req.setAttribute("recruitment", recruitment);
        render(req, resp, "/company/recruitment/detail", "template");
    }

}
