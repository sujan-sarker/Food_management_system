package net.therap.service;

import net.therap.domain.DayAndMealItem;
import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public User verifyUser(User user);
    void updateMenu(DayAndMealItem dayAndMealItem);
}

