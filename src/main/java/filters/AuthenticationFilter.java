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

@WebFilter("/*")
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
        if (session == null) {
            chain.doFilter(request, response);
            return;
        }

        Object _account = session.getAttribute("account");
        
        if (_account == null) {
            chain.doFilter(request, response);
            return;
        }

        Account account = (Account) _account;
        System.out.println(account.getRoleName());
        if (account.getRoleName().equals("Company")) {
            CompanyBO companyBO = new CompanyBO();
            Company company = companyBO.getCompanyByAccountId(account.getId());
            if (company == null) {
                throw new UnauthorizedException("Tài khoản không tồni");
            }
            System.out.println(company.getId());
            session.setAttribute("companyId", company.getId());
        }

        if (account.getRoleName().equals("User")) {
            User user = new UserBO().getUserByAccountId(account.getId());
            if (user == null) {
                throw new UnauthorizedException("Tài khoản không tồn tại");
            }
            System.out.println(user.getId());
            session.setAttribute("userId", user.getId());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
