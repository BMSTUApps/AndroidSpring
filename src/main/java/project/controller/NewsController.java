package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.dao.NewsDAO;
import project.model.DAOResponse;

@ResponseBody
@RestController
public class NewsController {
    private NewsDAO newsDAO;

    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @RequestMapping(path = "/news", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getStairsLinks() {
        DAOResponse daoResponse = newsDAO.getNews();
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.OK).body(daoResponse.body);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Some error happened while getting news");
    }
}
