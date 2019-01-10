package project.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dao.UserDAO;
import project.model.DAOResponse;
import project.model.User;

@ResponseBody
@RestController
public class SimpleController {

    private UserDAO userDAO;

    public SimpleController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User body) {
        DAOResponse daoResponse = userDAO.createUser(body);
        if (daoResponse.status == HttpStatus.OK) {
//            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
            return ResponseEntity.status(HttpStatus.CREATED).body(daoResponse.body);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Unsuccess");

    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        DAOResponse daoResponse = userDAO.getUserByID(id);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> checkUser(@RequestBody User body) {
        DAOResponse daoResponse = userDAO.checkUser(body);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
