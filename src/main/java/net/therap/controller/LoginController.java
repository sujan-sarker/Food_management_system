package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import net.therap.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/20/14
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/login.html")

public class LoginController extends HttpServlet {
    private UserService userService;

    public LoginController() {
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        User verifiedUser = userService.verifyUser(user);

        if (verifiedUser != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("verifiedUser", verifiedUser);
            response.sendRedirect(getServletContext().getContextPath()+"/home.html");
        } else {
            request.setAttribute("message","username or password invalid");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}

