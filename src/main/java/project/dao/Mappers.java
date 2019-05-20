package project.dao;

import org.springframework.jdbc.core.RowMapper;
import project.model.*;

import java.sql.Array;
import java.sql.Date;

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
        String point_from = res.getString("point_from");
        String point_to = res.getString("point_to");

        return new UsersHistory(id, user_id, point_from, point_to);
    };

    public static final RowMapper<MapStairs> mapStairsMapper = (res, num) -> {
        Integer id = res.getInt("id");
        Integer x = res.getInt("x");
        Integer y = res.getInt("y");
        Integer level = res.getInt("level");
        Boolean open = res.getBoolean("open");

        return new MapStairs(id, x, y, level, open);
    };

    // zalupaMapper тк mapStairsLinkMapper не работает !!!!!!!!!!!!!!(минус час жизни)
    public static final RowMapper<MapStairsLink> zalupaMapper = (res, num) -> {
        Integer id = res.getInt("id");
        Integer idFrom = res.getInt("id_from");
        Integer idTo = res.getInt("id_to");
        Integer weight = res.getInt("weight");
        Boolean open = res.getBoolean("open");

        return new MapStairsLink(id, idFrom, idTo, weight, open);
    };

    public static final RowMapper<MapWall> mapWallMapper = (res, num) -> {
        Integer id = res.getInt("id");
        Integer level = res.getInt("level");
        Integer x_f = res.getInt("x_first");
        Integer y_f = res.getInt("y_first");
        Integer x_s = res.getInt("x_second");
        Integer y_s = res.getInt("y_second");

        return new MapWall(id, level, x_f, y_f, x_s, y_s);
    };

    public static final RowMapper<News> newsMapper = (res, num) -> {
        Integer id = res.getInt("id");
        String title = res.getString("title");
        Date time = res.getDate("time");
        String payload = res.getString("payload");

        return new News(id, title, time, payload);
    };
}
