package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.MapStairsLink;
import project.model.News;

import java.sql.PreparedStatement;
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

    public DAOResponse insertNews(News news) {
        DAOResponse<News> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(connection -> {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO news (title, payload) VALUES(?, ?);",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, news.getTitle());
                statement.setString(2, news.getPayload());

                return statement;
            }, keyHolder);
            result.body = news;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.CONFLICT;
        }

        return result;
    }
}
