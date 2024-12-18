package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo nếu cần
    }

    @Override
    public void doFilter(jakarta.servlet.ServletRequest req, jakarta.servlet.ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);
        String role = (session != null) ? (String) session.getAttribute("role") : null;
        String path = request.getRequestURI();

        // Phân quyền dựa trên URL và role
        if (path.startsWith(request.getContextPath() + "/admin/")) { // URL dành cho Admin
            if (role == null || !role.equals("Admin")) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Chỉ Admin mới được sử dụng chức năng này!");
            }
        }
        if (path.startsWith(request.getContextPath() + "/company/")) { // URL dành cho Company
            if (role == null || !role.equals("Company")) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Chỉ Company mới được sử dụng chức năng này!");
            }
        }
        if (path.startsWith(request.getContextPath() + "/user/")) { // URL dành cho Employee
            if (role == null || !role.equals("User")) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Chỉ Employee mới được sử dụng chức năng này!");
            }
        }

        chain.doFilter(request, response); // Tiếp tục xử lý request
    }


    @Override
    public void destroy() {
        // Hủy Filter nếu cần
    }
}
