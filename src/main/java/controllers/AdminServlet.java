package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bo.AccountBO;

import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/*"})
public class AdminServlet extends BaseController {
    AccountBO accountBO = new AccountBO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        switch (path) {
            case "/create-account":
                render(req, resp, "/admin/account/create", "template");
                break;
            case "/list-accounts":
                render(req, resp, "/admin/account/list", "template");
                break;
            default:
                throw new NotFoundException();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        switch (path) {
            case "/create-account" -> {
                String companyName = req.getParameter("companyName");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                String companyLogo = "https://dy5f5j6i37p1a.cloudfront.net/facebook/jobshare/681bab12f6e911ea92ebb946eb46c611.jpg";
                // tạo account cho company ....
                accountBO.handleCreateCompanyAccount(email, password, companyName, companyLogo);
            }

            default -> {
                throw new NotFoundException();
            }

        }
    }
}
