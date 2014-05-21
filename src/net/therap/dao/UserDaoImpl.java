package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.DatabaseTemplate;
import net.therap.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao {

    public User getUserByName(String userName) {
        List<User> listOfUser;
        listOfUser = DatabaseTemplate.queryForObject("select * from user where name = '" + userName + "'", new ObjectRowMapper<User>() {
            public User mapRowToObject(ResultSet resultset) throws SQLException {
                User user = new User();
                user.setUserId(resultset.getInt("id"));
                user.setUserName(resultset.getString("name"));
                user.setPassword(resultset.getString("password"));
                return user;
            }
        });

        if (listOfUser.size() != 0) {
            return listOfUser.get(0);
        } else {
            return null;
        }
    }
}
