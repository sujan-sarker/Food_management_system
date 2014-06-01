package net.therap.domain;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class DayAndMealItem {
    private int dayId;
    private String dayName;
    private String breakfastItem;
    private String lunchItem;

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
    public void setBreakfastItem(String breakfastItem) {
        this.breakfastItem = breakfastItem;
    }
    public void setLunchItem(String lunchItem) {
        this.lunchItem = lunchItem;
    }
    public int getDayId() {
        return this.dayId;
    }
    public String getBreakfastItem() {
        return this.breakfastItem;
    }
    public String getLunchItem() {
        return this.lunchItem;
    }
    public String getDayName() {
        return this.dayName;
    }
}
