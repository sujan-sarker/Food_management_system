package net.therap.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/21/14
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTemplate {
    public static <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper) {
        Connection connectionToUse = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();

        try {
            connectionToUse = DatabaseConnection.getConnection();
            statement = connectionToUse.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOfE;
    }
}
