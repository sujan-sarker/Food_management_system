package net.therap.sevice;

import net.therap.dao.UserDao;
import net.therap.dao.UserDaoImpl;
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

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }
    public User verifyUser(User user) {
      User verifiedUser = userDao.getUserByName(user.getUserName());

      if(verifiedUser!=null && verifiedUser.getPassword().equals(user.getPassword())) {
          System.out.println(verifiedUser.getUserName());
          return user;
      } else {
          return null;
      }
    }
}
