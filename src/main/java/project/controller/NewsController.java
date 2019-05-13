package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dao.NewsDAO;
import project.model.DAOResponse;
import project.model.News;

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

    @RequestMapping(path = "/news", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertNews(@RequestBody News body) {
        DAOResponse daoResponse = newsDAO.insertNews(body);
        if (daoResponse.status == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.CREATED).body(daoResponse.body);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Unsuccess stair link inset");
    }
}
