package controllers;

import java.io.IOException;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Account;
import models.bo.AccountBO;

@WebServlet(name = "AccountServlet", urlPatterns = {"/auth/*"})
public class AccountServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        boolean loggedIn = request.getSession().getAttribute("loggedin") != null
//                ? (Boolean) request.getSession().getAttribute("loggedin")
//                : false;
//        if (loggedIn) {
//            request.getSession().removeAttribute("loggedin");
//        }
        String path = request.getPathInfo() == null ? "/" : request.getPathInfo();
        switch (path) {
            case "/login" -> render(request, response, "/auth/sign_in");
            case "/register" -> render(request, response, "/auth/sign_up");
            default -> throw new NotFoundException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo() == null ? "/" : request.getPathInfo();
        switch (path) {
            case "/login" -> login(request, response);
            case "/register" -> register(request, response);
            default -> throw new NotFoundException();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean check = AccountBO.checkLogin(new Account(email, password));
        if (check) {
            request.getSession().setAttribute("loggedin", true);
            render(request, response, "/home");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password!");
            render(request, response, "/WEB-INF/pages/login.jsp");
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //
    }
}
