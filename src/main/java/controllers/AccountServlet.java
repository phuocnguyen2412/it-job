package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.Account;
import models.bean.NhanVien;
import models.bo.AccountBO;
import models.dao.NhanVienDAO;

import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = {"/login"})
public class AccountServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean loggedIn = request.getSession().getAttribute("loggedin") != null
                ? (Boolean) request.getSession().getAttribute("loggedin")
                : false;
        if (loggedIn) {
            request.getSession().removeAttribute("loggedin");
        }
        render(request, response, "/WEB-INF/pages/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean check = AccountBO.checkLogin(new Account(username, password));
        if (check) {
            NhanVien nv = new NhanVienDAO().getNhanVienById("NV01");
            request.setAttribute("NhanVien", nv);
            request.getSession().setAttribute("loggedin", true);
            render(request, response, "/WEB-INF/pages/home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password!");
            render(request, response, "/WEB-INF/pages/login.jsp");

        }
    }
}
