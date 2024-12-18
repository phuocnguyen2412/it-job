package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.CompanyAddress;
import models.bean.Recruitment;
import models.bo.RecruitmentBO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CompanyServlet", urlPatterns = {"/company/*"})
public class CompanyServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        System.out.println(path);
        switch (path) {

            case "/create-recruitment":
                List<CompanyAddress> addresses = new ArrayList<>() {
                    {
                        add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
                        add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
                    }
                };
                req.setAttribute("addresses", addresses);
                render(req, resp, "/company/recruitment/create", "template");
                break;
            case "/edit-recruitment":
                get_edit_recruitment(req, resp);
                break;
            case "/edit":
                get_edit(req, resp);
                break;
            case "/list-recruitment":
                System.out.println("List recruitment");
                Recruitment recruitment = new RecruitmentBO().mockRecruitment();

                List<Recruitment> recruitments = new ArrayList<>() {
                    {
                        add(recruitment);
                        add(recruitment);
                        add(recruitment);
                        add(recruitment);
                    }
                };
                req.setAttribute("recruitments", recruitments);
                render(req, resp, "/company/recruitment/list", "template");
                break;
            default:
                System.out.println("Not found");
                throw new NotFoundException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        System.out.println(path);
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
        Recruitment recruitment = new Recruitment();
        recruitment.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        recruitment.setPosition("Java Developer");
        recruitment.setJobDescription("Develop software applications using Java programming language");
        recruitment.setRequirement("At least 1 year of experience in Java programming");
        recruitment.setRangeOfSalaryFrom(1000);
        recruitment.setRangeOfSalaryTo(2000);
        recruitment.setSkills("java,c++,c#,python,javascript");
        recruitment.setBenefit("13th month salary, health insurance, annual leave");
        req.setAttribute("recruitment", recruitment);
        render(req, resp, "/company/recruitment/edit", "template");
    }

    private void post_edit_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Recruitment recruitment = getRecruitment(req);
        System.out.println(recruitment);
        render(req, resp, "/company/recruitment/edit", "template");
    }

    private void post_edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = new Company();
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
        Company company = new Company();
        company.setName("FPT Software");
        company.setEmail("Huynhphuocnguyen@gmail.com");
        company.setIndustry("Software Development Outsourcing");
        company.setSize("1000-5000");
        company.setWorkingDays("Mon-Fri");
        company.setIntroduce("FPT Software is a global company with offices in 52 countries. With 20 years of experience in the technology industry, we have a team of more than 10,000 professionals working in 33 countries. We provide world-class software development services in the areas of digital transformation, cloud computing, AI, IoT, and more.");
        company.setLogo("https://rubicmarketing.com/wp-content/uploads/2022/07/y-nghia-logo-fpt-lan-3.jpg");
        company.setSkills("java, c++, c#, python, javascript");
        req.setAttribute("company", company);
        render(req, resp, "/company/edit", "template");

    }

    private void post_create_recruitment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Recruitment recruitment = getRecruitment(req);
        String[] selectedAddressIds = req.getParameterValues("selectedAddresses");
        List<Integer> selectedAddresses = new ArrayList<>();
        if (selectedAddressIds != null) {
            // Chuyển các ID thành đối tượng CompanyAddress

            for (String id : selectedAddressIds) {
                int addressId = Integer.parseInt(id);
                System.out.println(addressId);
                selectedAddresses.add(addressId);

            }
        }
        System.out.println(selectedAddresses);
        System.out.println(recruitment);
        req.setAttribute("recruitment", recruitment);
        render(req, resp, "/company/recruitment/detail", "template");
    }


}
