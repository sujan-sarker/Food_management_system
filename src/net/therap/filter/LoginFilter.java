package net.therap.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if ((session == null || session.getAttribute("verifiedUser") == null) && (requestedUri.contains("home") || requestedUri.contains("logout"))) {

            ((HttpServletResponse) servletResponse).sendRedirect("/login.html");

        } else if (session != null && session.getAttribute("verifiedUser") != null && (requestedUri.contains("login") || requestedUri.contains("register"))) {

            ((HttpServletResponse) servletResponse).sendRedirect("/home.html");

        } else {

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
