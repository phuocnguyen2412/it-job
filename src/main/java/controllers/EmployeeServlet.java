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

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends BaseController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        boolean loggedIn = req.getSession().getAttribute("loggedin") != null
                ? (Boolean) req.getSession().getAttribute("loggedin")
                : false;

        switch (action) {
            case "create":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                String id = req.getParameter("IDNV");
                System.out.println(id);
                NhanVien empployeeCreate = new NhanVien(
                        req.getParameter("DiaChi"),
                        req.getParameter("IDPB"),
                        req.getParameter("HoTen"),
                        req.getParameter("IDNV")

                );
                NhanVienBO.createNhanVien(empployeeCreate);

                resp.sendRedirect(req.getContextPath() + "/employee?action=index");
                break;
            case "deleteMulti":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                String[] ids = req.getParameterValues("selectedEmployees[]");
                NhanVienBO.deleteMultiNhanVien(ids);
                resp.sendRedirect(req.getContextPath() + "/employee?action=index");
                break;

            case "edit":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                NhanVien empployeeEdit = new NhanVien(
                        req.getParameter("DiaChi"),
                        req.getParameter("IDPB"),
                        req.getParameter("HoTen"),
                        req.getParameter("IDNV")
                );
                System.out.println(empployeeEdit.getDiaChi());
                NhanVienBO.updateNhanVien(empployeeEdit);
                resp.sendRedirect(req.getContextPath() + "/employee?action=index");
                break;

            default:
                render(req, resp, "/WEB-INF/pages/home.jsp");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "index";

        boolean loggedIn = req.getSession().getAttribute("loggedin") != null
                ? (Boolean) req.getSession().getAttribute("loggedin")
                : false;

        switch (action) {
            case "index":
                List<NhanVien> employees = NhanVienBO.getAllNhanVien();
                req.setAttribute("employees", employees);
                render(req, resp, "/WEB-INF/pages/employee/index.jsp");
                break;

            case "delete":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                NhanVienBO.deleteNhanVien(req.getParameter("IDNV"));
                resp.sendRedirect(req.getContextPath() + "/employee?action=index");
                break;


            case "find":
                String key = req.getParameter("key");
                String value = req.getParameter("value");

                if (key == null || value == null) {
                    List<NhanVien> employeesFind = NhanVienBO.getAllNhanVien();
                    req.setAttribute("employees", employeesFind);
                } else {
                    req.setAttribute("employees", NhanVienBO.findNhanVien(key, value));
                }
                render(req, resp, "/WEB-INF/pages/employee/find.jsp");
                break;
            case "create":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                List<PhongBan> phongBanList = PhongBanBO.getAllPhongBan();
                req.setAttribute("phongBanList", phongBanList);
                render(req, resp, "/WEB-INF/pages/employee/create.jsp");
                break;
            case "edit":
                if (!loggedIn) {
                    render(req, resp, "/WEB-INF/pages/error.jsp");
                    return;
                }

                String idEdit = req.getParameter("IDNV");

                NhanVien employee = NhanVienBO.getNhanVienById(idEdit);
                req.setAttribute("NhanVien", employee);

                List<PhongBan> phongBanListEdit = PhongBanBO.getAllPhongBan();
                req.setAttribute("phongBanList", phongBanListEdit);

                render(req, resp, "/WEB-INF/pages/employee/edit.jsp");
                break;

            default:
                render(req, resp, "/WEB-INF/pages/home.jsp");
                break;
        }
    }
}
