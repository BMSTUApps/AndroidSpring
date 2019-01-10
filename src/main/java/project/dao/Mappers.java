package project.dao;

import org.springframework.jdbc.core.RowMapper;
import project.model.User;
import project.model.UsersHistory;

import java.sql.Array;

public class Mappers {

    public static final RowMapper<User> userMapper = (res, num) -> {
        Integer id = res.getInt("id");
        String login = res.getString("login");
        String password = res.getString("password");
        return new User(id, login, password);
    };

    public static final RowMapper<UsersHistory> userHistoryMapper = (res, num) -> {
        Integer id = res.getInt("id");
        Integer user_id = res.getInt("user_id");
        Integer point_from = res.getInt("point_from");
        Integer point_to = res.getInt("point_to");
        return new UsersHistory(id, user_id, point_from, point_to);
    };
}
