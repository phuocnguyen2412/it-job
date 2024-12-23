package controllers;


import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Account;
import models.bo.AccountBO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet", urlPatterns = {"/auth/*"})
public class AccountServlet extends BaseController {
    private AccountBO accountBO;

    public void init() throws ServletException {
        super.init();
        accountBO = new AccountBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo() == null ? "/" : request.getPathInfo();
        switch (path) {
            case "/login" -> render(request, response, "/auth/sign_in");
            case "/register" -> render(request, response, "/auth/sign_up");
            default -> throw new NotFoundException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = request.getPathInfo() == null ? "/" : request.getPathInfo();
            switch (path) {
                case "/login" -> login(request, response);
                case "/register" -> register(request, response);
                default -> throw new NotFoundException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        AccountBO accountBO = new AccountBO();
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Account account = accountBO.checkSignIn(email, password);

            if (account != null) {
                request.getSession().setAttribute("account", account);
                request.getSession().setAttribute("loggedin", true);
                request.getSession().setAttribute("role", account.getRoleName());
                response.sendRedirect("http://localhost:8080/demo_jsp_war_exploded/home");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("errorMessage", "Invalid username or password!");
            render(request, response, "/auth/sign_in");
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccountBO accountBO = new AccountBO();
        try {
            int result = accountBO.handleCreateUser(name, email, password);
            if (result > 0) {
                response.sendRedirect("http://localhost:8080/demo_jsp_war_exploded/auth/login");
            } else {
                response.sendRedirect("http://localhost:8080/demo_jsp_war_exploded/auth/register");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
