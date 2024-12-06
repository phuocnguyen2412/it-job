package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

abstract public class BaseController extends HttpServlet {
    protected void render(HttpServletRequest req, HttpServletResponse resp, String contentPage) throws ServletException, IOException {
        req.setAttribute("contentPage", contentPage);
        req.getRequestDispatcher("/WEB-INF/layouts/template.jsp").forward(req, resp);
    }
}
