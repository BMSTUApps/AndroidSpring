package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.News;

import java.util.List;

@Service
public class NewsDAO {
    private final JdbcTemplate template;

    public NewsDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse getNews() {
        DAOResponse<List<News>> result = new DAOResponse<>();
        try {
            result.body = template.query("SELECT * FROM news",
                    new Object[]{}, Mappers.newsMapper);
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }
}
