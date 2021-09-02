package ru.javavision.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CookieLocaleFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getParameter("cookieLocale") != null) {
            Cookie cookie = Arrays.stream(req.getCookies())
                    .filter(c -> c.getName().equals("lang"))
                    .findAny()
                    .orElse(new Cookie("lang","en"));

            cookie.setValue(req.getParameter("cookieLocale"));
            res.addCookie(cookie);
        }

        chain.doFilter(req, res);
    }

    public void destroy() {}

    public void init(FilterConfig arg0) throws ServletException {}

}
