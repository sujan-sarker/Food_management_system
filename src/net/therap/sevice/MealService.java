package net.therap.sevice;

import net.therap.domain.DayAndMealItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MealService {
    public List<DayAndMealItem> getMealList();
}
