package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.MapWall;

import java.util.List;

@Service
public class MapWallDAO {
    private final JdbcTemplate template;

    public MapWallDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse getAllWalls() {
        DAOResponse<List<MapWall>> result = new DAOResponse<>();
        try {
            result.body = template.query("SELECT * FROM map_level_walls",
                    new Object[]{}, Mappers.mapWallMapper);
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }
}
