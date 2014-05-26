package net.therap.service;

import net.therap.dao.MealDao;
import net.therap.dao.MealDaoImpl;
import net.therap.dao.UserDao;
import net.therap.dao.UserDaoImpl;
import net.therap.domain.DayAndMealItem;
import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private MealDao mealDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
        mealDao = new MealDaoImpl();
    }
    public User verifyUser(User user) {
      User verifiedUser = userDao.getUserByName(user.getUserName());
      if(verifiedUser!=null && verifiedUser.getPassword().equals(user.getPassword())) {
          return verifiedUser;
      } else {
          return null;
      }
    }
    public void updateMenu(DayAndMealItem dayAndMealItem) {
       mealDao.updateMeal(dayAndMealItem);
    }
}
