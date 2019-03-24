package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.MapStairsLink;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class MapStairsLinkDAO {
    private final JdbcTemplate template;

    public MapStairsLinkDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse insertStairsLink(MapStairsLink mapStairsLink) {
        DAOResponse<MapStairsLink> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(connection -> {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO map_stairs_link (id_from, id_to, weight, open) VALUES(?, ?, ?, ?);",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1, mapStairsLink.getIdFrom());
                statement.setInt(2, mapStairsLink.getIdTo());
                statement.setInt(3, mapStairsLink.getWeight());
                statement.setBoolean(4, mapStairsLink.getOpen());

                return statement;
            }, keyHolder);
            result.body = mapStairsLink;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.CONFLICT;
        }
        return result;
    }

    public DAOResponse getAllStairsLinks() {
        DAOResponse<List<MapStairsLink>> result = new DAOResponse<>();
        try {
            result.body = template.query("SELECT * FROM map_stairs_link",
                    new Object[]{}, Mappers.zalupaMapper);
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }
}
