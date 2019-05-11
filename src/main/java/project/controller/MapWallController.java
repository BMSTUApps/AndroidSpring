package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.dao.MapWallDAO;
import project.model.DAOResponse;
import project.model.MapWall;

@ResponseBody
@RestController
public class MapWallController {
    private MapWallDAO mapWallDAO;

    public MapWallController(MapWallDAO mapWallDAO) {
        this.mapWallDAO = mapWallDAO;
    }

    @RequestMapping(path = "/map/walls/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getStairsLinks() {
        DAOResponse daoResponse = mapWallDAO.getAllWalls();
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Some error happened while getting walls");
    }
}
