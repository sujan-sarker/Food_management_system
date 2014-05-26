package net.therap.controller;

import net.therap.domain.DayAndMealItem;
import net.therap.service.MealService;
import net.therap.service.MealServiceImpl;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/22/14
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/save.html")
public class SaveMenuItemController extends HttpServlet {

    private UserService userService;
    private MealService mealService;

    public SaveMenuItemController() {
        userService = new UserServiceImpl();
        mealService = new MealServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String updatedMenu = request.getParameter("newMeal");
        String dayId = request.getParameter("dayId");
        String mealType = request.getParameter("mealType");
        DayAndMealItem dayAndMealItem = new DayAndMealItem();

        dayAndMealItem.setDayId(Integer.parseInt(dayId));
        if (mealType.equals("breakfast")) {
             dayAndMealItem.setBreakfastItem(updatedMenu);
        } else {
             dayAndMealItem.setLunchItem(updatedMenu);
        }
        userService.updateMenu(dayAndMealItem);
        List<DayAndMealItem> mealList =mealService.getMealList();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("mealList",mealList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/edit_menu.jsp");
        requestDispatcher.forward(request, response);
    }


}
