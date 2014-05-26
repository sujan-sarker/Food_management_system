package net.therap.dao;

import net.therap.domain.DayAndMealItem;
import net.therap.domain.User;
import net.therap.util.DatabaseTemplate;
import net.therap.util.ObjectRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class MealDaoImpl implements MealDao{
    @Override
    public List<DayAndMealItem> getMealList() {
        List<DayAndMealItem> mealList;
        mealList = DatabaseTemplate.queryForObject("select * from meal_schedule", new ObjectRowMapper<DayAndMealItem>() {
            public DayAndMealItem mapRowToObject(ResultSet resultset) throws SQLException {
                DayAndMealItem dayAndMealItem = new DayAndMealItem();
                dayAndMealItem.setDayId(resultset.getInt("day_id"));
                dayAndMealItem.setBreakfastItem(resultset.getString("breakfast"));
                dayAndMealItem.setLunchItem(resultset.getString("lunch"));
                dayAndMealItem.setDayName(resultset.getString("name"));
                return dayAndMealItem;
            }
        });

        return mealList;
    }

    public void updateMeal(DayAndMealItem dayAndMealItem) {
        String mealType;
        String updatedMenu;
        int dayId;

        if(dayAndMealItem.getBreakfastItem()==null) {
            mealType = "lunch";
            updatedMenu = dayAndMealItem.getLunchItem();
        } else {
            mealType ="breakfast";
            updatedMenu = dayAndMealItem.getBreakfastItem();
        }
        dayId = dayAndMealItem.getDayId();

        DatabaseTemplate.executeInsertUpdateQuery("update meal_schedule set "+mealType+"=? where day_id=?",updatedMenu,dayId);
    }
}
