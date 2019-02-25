package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dao.MapStairsDAO;
import project.model.DAOResponse;
import project.model.MapStairs;

@ResponseBody
@RestController
public class MapStairsController {
    private MapStairsDAO mapStairsDAO;

    public MapStairsController(MapStairsDAO mapStairsDAO) {
        this.mapStairsDAO = mapStairsDAO;
    }

    @RequestMapping(path = "/map/stairs/insert", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertStairs(@RequestBody MapStairs body) {
        DAOResponse daoResponse = mapStairsDAO.insertStairs(body);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.CREATED).body(daoResponse.body);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Unsuccess");
    }

}
