package net.therap.controller;

import net.therap.Listener.SessionListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/25/14
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/count_user.html")
public class UserCountController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int totalUser= SessionListener.getTotalUser();
        request.setAttribute("totalUser",totalUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/count_user.jsp");
        requestDispatcher.forward(request,response);

    }
}
