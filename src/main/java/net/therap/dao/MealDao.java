package net.therap.dao;

import net.therap.domain.DayAndMealItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MealDao {

    public List<DayAndMealItem> getMealList();
    void updateMeal(DayAndMealItem dayAndMealItem);
}
