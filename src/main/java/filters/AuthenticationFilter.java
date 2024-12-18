package filters;

import exception.UnauthorizedException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.bean.Account;
import models.bean.Company;
import models.bean.User;
import models.bo.CompanyBO;
import models.bo.UserBO;

import java.io.IOException;

@WebFilter({})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo filter nếu cần
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        Account account = (Account) session.getAttribute("account");


        if (session == null || session.getAttribute("userId") == null || !(Boolean) session.getAttribute("isSignedIn")) {
            throw new UnauthorizedException("Bạn phải đăng nhập!");
        }

        if (account.getRoleName().equals("Company")) {
            CompanyBO companyBO = new CompanyBO();

            Company company = companyBO.getCompanyByAccountId(account.getId());
            if (company == null) {
                throw new UnauthorizedException("Tài khoản không tồni");
            }
            session.setAttribute("companyId", company.getId());
        }

        if (account.getRoleName().equals("User")) {
            User user = new UserBO().getUserByAccountId(account.getId());
            if (user == null) {
                throw new UnauthorizedException("Tài khoản không tồn tại");
            }
            session.setAttribute("userId", user.getId());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
