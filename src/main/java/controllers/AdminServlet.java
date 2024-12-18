package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/*"})
public class AdminServlet extends BaseController {
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
                String companyLogo = req.getParameter("companyLogo");
                // tạo account cho company ....
            }

            default -> {
                throw new NotFoundException();
            }

        }
    }
}
