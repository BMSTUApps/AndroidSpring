package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dao.MapStairsLinkDAO;
import project.model.DAOResponse;
import project.model.MapStairsLink;

@ResponseBody
@RestController
public class MapStairsLinkController {
    private MapStairsLinkDAO mapStairsLinkDAO;

    public MapStairsLinkController(MapStairsLinkDAO mapStairsLinkDAO) {
        this.mapStairsLinkDAO = mapStairsLinkDAO;
    }

    @RequestMapping(path = "/map/links/stairs/insert", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertStairs(@RequestBody MapStairsLink body) {
        DAOResponse daoResponse = mapStairsLinkDAO.insertStairsLink(body);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.CREATED).body(daoResponse.body);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Unsuccess");
    }

    @RequestMapping(path = "/map/links/stairs/getall", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getStairs() {
        DAOResponse daoResponse = mapStairsLinkDAO.getAllStairsLinks();
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Some error happened");
    }
}
