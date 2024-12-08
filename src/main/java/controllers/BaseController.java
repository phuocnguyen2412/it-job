package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

abstract public class BaseController extends HttpServlet {
    protected void render(HttpServletRequest req, HttpServletResponse resp, String contentPage, String layout) throws ServletException, IOException {
        req.setAttribute("contentPage", contentPage);
        req.getRequestDispatcher("/WEB-INF/layouts/" + layout + ".jsp").forward(req, resp);
    }

    protected void render(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages" + path + "/index.jsp").forward(req, resp);
    }
}
