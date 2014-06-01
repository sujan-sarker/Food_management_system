package net.therap.controller;

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
 * Date: 5/22/14
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/edit_menu.html")
public class EditMenuController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dayId = request.getParameter("dayId");
        String mealType = request.getParameter("mealType") ;

        request.setAttribute("dayId",dayId);
        request.setAttribute("mealType",mealType);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/edit_menu.jsp");
        requestDispatcher.forward(request, response);
    }
}
