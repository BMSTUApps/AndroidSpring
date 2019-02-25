package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.MapStairs;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class MapStairsDAO {
    private final JdbcTemplate template;

    public MapStairsDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse insertStairs(MapStairs mapStairs) {
        DAOResponse<MapStairs> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(connection -> {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO  map_stairs (x, y, level, open) VALUES(?, ?, ?, ?);",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1, mapStairs.getX());
                statement.setInt(2, mapStairs.getY());
                statement.setInt(3, mapStairs.getLevel());
                statement.setBoolean(4, mapStairs.getOpen());

                return statement;
            },keyHolder);
            result.body = mapStairs;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.CONFLICT;
        }
        return result;
    }

    public DAOResponse getAllStairs() {
        DAOResponse<List<MapStairs>> result = new DAOResponse<>();
        try {
            result.body =  template.query("SELECT * FROM map_stairs",
                    new Object[]{}, Mappers.mapStairsMapper);
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }

}
