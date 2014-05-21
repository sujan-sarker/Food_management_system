package net.therap.dao;

import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User getUserByName(String userName);
}
