package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dao.UsersHistoryDAO;
import project.model.DAOResponse;
import project.model.UsersHistory;

@ResponseBody
@RestController
public class UsersHistoryController {
    private UsersHistoryDAO usersHistoryDAO;

    public UsersHistoryController(UsersHistoryDAO usersHistoryDAO) {
        this.usersHistoryDAO = usersHistoryDAO;
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertRoute(@RequestBody UsersHistory body) {
        DAOResponse daoResponse = usersHistoryDAO.insertRoute(body);
        if (daoResponse.status == HttpStatus.OK) {
//            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
            return ResponseEntity.status(HttpStatus.CREATED).body(daoResponse.body);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Unsuccess");
    }

    @RequestMapping(path = "/get_routes/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getRoutesById(@PathVariable("id") Integer id) {
        DAOResponse daoResponse = usersHistoryDAO.getRoutesById(id);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @RequestMapping(path = "/clear_routes/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> clearRoutesById(@PathVariable("id") Integer id) {
        System.out.println("clear_routes + id = " + id.toString());
        DAOResponse daoResponse = usersHistoryDAO.clearRoutesById(id);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
    }
}
