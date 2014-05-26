package net.therap.service;

import net.therap.dao.MealDao;
import net.therap.dao.MealDaoImpl;
import net.therap.domain.DayAndMealItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class MealServiceImpl implements MealService {

    private MealDao mealDao;

    public MealServiceImpl() {
        mealDao = new MealDaoImpl();
    }
    public List<DayAndMealItem> getMealList() {
        List<DayAndMealItem> mealList = mealDao.getMealList();
        return mealList;
    }
}
