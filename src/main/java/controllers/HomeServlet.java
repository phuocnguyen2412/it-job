package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.CompanyAddress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = new Company();
        company.setName("FPT Software");
        company.setEmail("Huynhphuocnguyen@gmail.com");
        company.setIndustry("Software Development Outsourcing");
        company.setSize("1000-5000");
        company.setWorkingDays("Mon-Fri");
        company.setIntroduce("FPT Software is a global company with offices in 52 countries. With 20 years of experience in the technology industry, we have a team of more than 10,000 professionals working in 33 countries. We provide world-class software development services in the areas of digital transformation, cloud computing, AI, IoT, and more.");
        company.setLogo("https://rubicmarketing.com/wp-content/uploads/2022/07/y-nghia-logo-fpt-lan-3.jpg");
        company.setSkills("java, c++, c#, python, javascript");
        company.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
            }

        });
        List<Company> companies = new ArrayList<>() {
            {
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
                add(company);
            }
        };
        req.setAttribute("companies", companies);
        render(req, resp, "/home");
    }
}
