package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bean.NhanVien;
import models.bean.PhongBan;
import models.bo.NhanVienBO;
import models.bo.PhongBanBO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongBanServlet", urlPatterns = {"/phongban"})
public class PhongBanServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        boolean loggedIn = req.getSession().getAttribute("loggedin") != null
                ? (Boolean) req.getSession().getAttribute("loggedin")
                : false;
        switch (action) {
            case "index":
                List<PhongBan> phongBans = PhongBanBO.getAllPhongBan();
                req.setAttribute("phongBanList", phongBans);
                render(req, resp, "/WEB-INF/pages/phongban/index.jsp");
                break;

            case "detail":
                List<NhanVien> employees = NhanVienBO.getAllNhanVienByPhongBan(req.getParameter("id"));
                req.setAttribute("employees", employees);
                render(req, resp, "/WEB-INF/pages/phongban/detail.jsp");
                break;
            case "edit":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }
                PhongBan phongBan = PhongBanBO.getPhongBanById(req.getParameter("id"));
                req.setAttribute("phongBan", phongBan);
                render(req, resp, "/WEB-INF/pages/phongban/edit.jsp");
                break;
            default:
                render(req, resp, "/WEB-INF/pages/home.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        boolean loggedIn = req.getSession().getAttribute("loggedin") != null
                ? (Boolean) req.getSession().getAttribute("loggedin")
                : false;

        switch (action) {
            case "edit":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                PhongBan phongBan = new PhongBan(
                        req.getParameter("IDPB"),
                        req.getParameter("TenPB"),
                        req.getParameter("MoTa")
                );

                PhongBanBO.updatePhongBan(phongBan);
                resp.sendRedirect(req.getContextPath() + "/phongban?action=index");
                break;

            default:
                render(req, resp, "/WEB-INF/pages/home.jsp");
                break;
        }
    }
}
