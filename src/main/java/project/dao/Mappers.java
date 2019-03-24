package project.dao;

import org.springframework.jdbc.core.RowMapper;
import project.model.MapStairs;
import project.model.MapStairsLink;
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
}
