package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Application;
import models.bean.User;
import models.bo.ApplicationBO;
import models.bo.UserBO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends BaseController {
    private UserBO userBO;
    private ApplicationBO applicationBO;

    @Override
    public void init() throws ServletException {
        userBO = new UserBO();
        applicationBO = new ApplicationBO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();


        switch (path) {
            case "/profile" -> {
                int userId = (int) req.getSession().getAttribute("userId");
                User user = userBO.getUserById(userId);
                req.setAttribute("user", user);
                render(req, resp, "/user/profile");
            }

            case "/application" -> {
                int userId = (int) req.getSession().getAttribute("userId");
                /// Tìm các application theo user id
//                List<Application> applications = new ArrayList<>() {
//                    {
//                        add(applicationBO.mockApplication());
//                        add(applicationBO.mockApplication());
//                        add(applicationBO.mockApplication());
//                    }
//                };
                ArrayList<Application> applications = applicationBO.getApplicationByUserId(userId);
                req.setAttribute("applications", applications);
                render(req, resp, "/user/application");
            }

            default -> {
                throw new NotFoundException();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        String userId = (String) req.getSession().getAttribute("userId");
        switch (path) {
            case "/profile/information" -> {
                edit_infomation(req, resp);
            }
            case "/profile/introduce" -> {
                String introduce = req.getParameter("introduce");
                User user = new User();
                user.setIntroduce(introduce);
                user.setId(Integer.parseInt(userId));
                userBO.updateUser(user);
            }
            case "/create-application" -> {
                int recruitmentId = Integer.parseInt(req.getParameter("recruitmentId"));
                Application application = new Application();
                application.setUserId(Integer.parseInt(userId));
                application.setRecruitmentId(recruitmentId);
                // tạo application
            }
            default -> {
                throw new NotFoundException();
            }
        }
    }

    private void edit_infomation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setCity(address);

        req.setAttribute("user", user);
        render(req, resp, "/user/profile");
    }
}
