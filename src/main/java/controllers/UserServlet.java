package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Application;
import models.bean.PersonalProject;
import models.bean.User;
import models.bo.ApplicationBO;
import models.bo.PersonalProjectBO;
import models.bo.UserBO;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends BaseController {
    private UserBO userBO;
    private ApplicationBO applicationBO;
    private PersonalProjectBO personalProjectBO;

    @Override
    public void init() throws ServletException {
        userBO = new UserBO();
        applicationBO = new ApplicationBO();
        personalProjectBO = new PersonalProjectBO();
        a
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
        int userId = (int) req.getSession().getAttribute("userId");
        switch (path) {
            case "/profile/information" -> {
                edit_infomation(req, resp);
            }
            case "/profile/introduce" -> {
                String introduce = req.getParameter("introduce");
                User user = userBO.getUserById(userId);
                user.setIntroduce(introduce);
                userBO.updateUser(user);
            }
            case "/create-application" -> {
                int recruitmentId = Integer.parseInt(req.getParameter("recruitmentId"));
                Application application = new Application();
                application.setUserId(userId);
                application.setRecruitmentId(recruitmentId);
                // tạo application
                applicationBO.handleCreateApplication(application);
            }
            case "/profile/project" -> {
                add_project(req, resp);
            }
            default -> {
                throw new NotFoundException();
            }
        }
    }

    private void edit_infomation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String city = req.getParameter("city");
        String birthday = req.getParameter("birthday");

        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setCity(city);
        user.setBirthday(Date.valueOf(birthday));
        user.setId((int) req.getSession().getAttribute("userId"));

        req.setAttribute("user", user);
        render(req, resp, "/user/profile");
    }

    private void add_project(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String name = request.getParameter("projectName");
        String detail = request.getParameter("projectDetail");
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        String link = request.getParameter("projectLink");

        PersonalProject project = new PersonalProject();
        project.setName(name);
        project.setDetail(detail);
        project.setDateStart(Timestamp.valueOf(dateStart));
        project.setDateEnd(Timestamp.valueOf(dateEnd));
        project.setLink(link);
        project.setUserId((int) request.getSession().getAttribute("userId"));

        personalProjectBO.addProject(project);

        resp.sendRedirect("http://localhost:8080/demo_jsp_war_exploded/user/profile");
    }
}
