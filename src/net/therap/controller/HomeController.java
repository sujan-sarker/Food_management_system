package net.therap.controller;

import net.therap.domain.DayAndMealItem;
import net.therap.service.MealService;
import net.therap.service.MealServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet({"/home.html", "/current_day.html"})
public class HomeController extends HttpServlet {
    private MealService mealService;

    public HomeController() {
        mealService = new MealServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("/home.html")) {
            setMealPlanToSession(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
        } else {
            setCurrentDayToSession(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/current_day.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void setCurrentDayToSession(HttpServletRequest request) {

        Date date = new Date();
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String currentDay = format2.format(date);
        System.out.println("incontrollar" + currentDay);
        request.setAttribute("currentDay", currentDay);

    }

    public void setMealPlanToSession(HttpServletRequest request) {
        List<DayAndMealItem> mealList = mealService.getMealList();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("mealList", mealList);
    }
}
