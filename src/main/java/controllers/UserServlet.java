package controllers;

import exception.NotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();


        switch (path) {
            case "/profile":
                render(req, resp, "/user/profile");
                break;
            case "/register":
                render(req, resp, "/WEB-INF/pages/register.jsp");
                break;
            default:
                throw new NotFoundException();
        }
    }
}
