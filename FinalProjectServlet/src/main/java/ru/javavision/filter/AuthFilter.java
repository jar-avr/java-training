package ru.javavision.filter;

import ru.javavision.entity.Role;
import ru.javavision.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

/**
 * Acidification filter.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (loggedIn) {
            Role role = ((User) session.getAttribute("user")).getRole();
            String uri = request.getRequestURI();
            if ((role.getAuthority().equals("ROLE_PERSON") && uri.matches("/person/.*")) ||
                    (role.getAuthority().equals("ROLE_INSPECTOR") && uri.matches("/inspector/.*")) ||
                    (role.getAuthority().equals("ROLE_ADMIN") && uri.matches("/admin/.*"))) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/access_denied");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
    }

}
