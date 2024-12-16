package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.CompanyAddress;
import models.bean.Recruitment;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CompanyServlet", urlPatterns = {"/company/*"})
public class CompanyServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        switch (path) {
            case "/detail":
                detail(req, resp);
                break;
            case "/register":
                render(req, resp, "/WEB-INF/pages/register.jsp");
                break;
            default:
                throw new NotFoundException();
        }
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyId = req.getParameter("id");
        if (companyId == null) {
            throw new NotFoundException();
        }
        Company company = new Company();
        company.setName("FPT Software");
        company.setEmail("Huynhphuocnguyen@gmail.com");
        company.setIndustry("Software Development Outsourcing");
        company.setSize("1000-5000");
        company.setWorkingDays("Mon-Fri");
        company.setIntroduce("FPT Software is a global company with offices in 52 countries. With 20 years of experience in the technology industry, we have a team of more than 10,000 professionals working in 33 countries. We provide world-class software development services in the areas of digital transformation, cloud computing, AI, IoT, and more.");
        company.setLogo("https://rubicmarketing.com/wp-content/uploads/2022/07/y-nghia-logo-fpt-lan-3.jpg");
        company.setSkills("java, c++, c#, python, javascript");
        Recruitment recruitment = new Recruitment();
        recruitment.setPosition("Java Developer");
        recruitment.setJobDescription("Develop software applications using Java programming language");
        recruitment.setRequirement("At least 1 year of experience in Java programming");
        recruitment.setRangeOfSalaryFrom(1000);
        recruitment.setRangeOfSalaryTo(2000);
        recruitment.setSkills("java,c++,c#,python,javascript");
        recruitment.setBenefit("13th month salary, health insurance, annual leave");
        recruitment.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
            }
        });
        ArrayList<Recruitment> recruitments = new ArrayList<>() {
            {
                add(recruitment);
                add(recruitment);
                add(recruitment);
            }
        };
        req.setAttribute("recruitments", recruitments);
        req.setAttribute("company", company);
        render(req, resp, "/company/detail");
    }
}
