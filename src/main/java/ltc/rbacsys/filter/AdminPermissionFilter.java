package ltc.rbacsys.filter;

import ltc.rbacsys.bean.User;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminPermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = (User)((HttpServletRequest)servletRequest).getSession().getAttribute("user");
        if (user != null) {
            if (user.isAdmin()) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse)servletResponse).sendRedirect("/user/userinfo.html");
            }
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("/login.html");
        }

    }
}
