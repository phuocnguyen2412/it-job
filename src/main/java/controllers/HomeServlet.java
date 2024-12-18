package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Company;
import models.bean.CompanyAddress;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Company> companies = new ArrayList<>();

        // Công ty 1
        Company company1 = new Company();
        company1.setName("FPT Software");
        company1.setEmail("Huynhphuocnguyen@gmail.com");
        company1.setIndustry("Software Development Outsourcing");
        company1.setSize("1000-5000");
        company1.setWorkingDays("Mon-Fri");
        company1.setIntroduce("FPT Software is a global company with offices in 52 countries...");
        company1.setLogo("https://rubicmarketing.com/wp-content/uploads/2022/07/y-nghia-logo-fpt-lan-3.jpg");
        company1.setSkills("java, c++, c#, python, javascript");
        company1.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(1, 1, "Ha Noi", "FPT Software Building"));
            }
        });
        companies.add(company1);

        // Công ty 2
        Company company2 = new Company();
        company2.setName("Viettel");
        company2.setEmail("contact@viettel.com");
        company2.setIndustry("Telecommunications");
        company2.setSize("5000-10000");
        company2.setWorkingDays("Mon-Sat");
        company2.setIntroduce("Viettel is a leading telecommunications company in Vietnam...");
        company2.setLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMOfEGbR6U-dPgsKO0Ng01-T_jw94r8wwuTw&s");
        company2.setSkills("networking, java, big data, AI");
        company2.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(2, 1, "Ho Chi Minh City", "Viettel Headquarters"));
            }
        });
        companies.add(company2);

        // Công ty 3
        Company company3 = new Company();
        company3.setName("VNPT");
        company3.setEmail("support@vnpt.vn");
        company3.setIndustry("Telecommunications and IT");
        company3.setSize("1000-3000");
        company3.setWorkingDays("Mon-Fri");
        company3.setIntroduce("VNPT provides high-quality IT and telecommunication services...");
        company3.setLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_zlOnuKL_xSKy6vB7dNKRB_WWadf6XjlaQQ&s");
        company3.setSkills("cloud computing, AI, python, DevOps");
        company3.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(3, 1, "Da Nang", "VNPT Office"));
            }
        });
        companies.add(company3);

        // Công ty 4
        Company company4 = new Company();
        company4.setName("VNG Corporation");
        company4.setEmail("info@vng.com.vn");
        company4.setIndustry("Technology and Gaming");
        company4.setSize("3000-5000");
        company4.setWorkingDays("Mon-Fri");
        company4.setIntroduce("VNG is a leading internet company in Vietnam specializing in...");
        company4.setLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMOfEGbR6U-dPgsKO0Ng01-T_jw94r8wwuTw&s");
        company4.setSkills("game development, C++, python, javascript");
        company4.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(4, 1, "Ho Chi Minh City", "VNG Campus"));
            }
        });
        companies.add(company4);

        // Công ty 5
        Company company5 = new Company();
        company5.setName("TMA Solutions");
        company5.setEmail("contact@tmasolutions.com");
        company5.setIndustry("Software Development");
        company5.setSize("1000-2000");
        company5.setWorkingDays("Mon-Fri");
        company5.setIntroduce("TMA Solutions is a leading software outsourcing company...");
        company5.setLogo("https://www.tmasolutions.vn/TMA-logo.png");
        company5.setSkills("java, .net, python, testing");
        company5.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(5, 1, "Binh Duong", "TMA Tower"));
            }
        });
        companies.add(company5);

        // Công ty 6
        Company company6 = new Company();
        company6.setName("Axon Active Vietnam");
        company6.setEmail("info@axonactive.com");
        company6.setIndustry("Agile Software Development");
        company6.setSize("500-1000");
        company6.setWorkingDays("Mon-Fri");
        company6.setIntroduce("Axon Active specializes in offshore software development...");
        company6.setLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTRGgYEUj9ctDqtfuGtMJohB6RWESfm7sTkA&s");
        company6.setSkills("agile, java, angular, python");
        company6.setAddresses(new ArrayList<>() {
            {
                add(new CompanyAddress(6, 1, "Can Tho", "Axon Active Office"));
            }
        });
        companies.add(company6);
        req.setAttribute("companies", companies);
        render(req, resp, "/home");
    }
}
