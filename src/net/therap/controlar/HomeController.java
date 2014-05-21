package net.therap.controlar;

import net.therap.domain.DayAndMealItem;
import net.therap.sevice.MealService;
import net.therap.sevice.MealServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet("/home.html")
public class HomeController extends HttpServlet {
    private MealService mealService;

    public HomeController() {
        mealService = new MealServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setMealPlanToSession(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
    }

    public void setMealPlanToSession(HttpServletRequest request) {
        List<DayAndMealItem> mealList =mealService.getMealList();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("mealList",mealList);
    }
}
