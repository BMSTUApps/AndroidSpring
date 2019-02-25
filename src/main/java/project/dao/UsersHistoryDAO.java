package project.dao;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.UsersHistory;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class UsersHistoryDAO {
    private final JdbcTemplate template;

    public UsersHistoryDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse insertRoute(UsersHistory usersHistory) {
        DAOResponse<UsersHistory> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(connection -> {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO  users_history (user_id, point_from, point_to) VALUES(?, ?, ?);",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1, usersHistory.getUser_id());
                statement.setInt(2, usersHistory.getPoint_from());
                statement.setInt(3, usersHistory.getPoint_to());

                return statement;
            },keyHolder);
            result.body = usersHistory;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.CONFLICT;
        }
        return result;
    }

    public DAOResponse getRoutesById(Integer id) {
        DAOResponse<List<UsersHistory>> result = new DAOResponse<>();
        try {
//            List<Object> tmpObj = new ArrayList<>();
//            tmpObj.add(id);
//            final UsersHistory usersHistory = template.queryForObject("SELECT * FROM \"users_histiory\" WHERE  = ?",
//                    new Object[]{id}, Mappers.userHistoryMapper);
            result.body =  template.query("SELECT * FROM users_history WHERE user_id = ?",
                    new Object[]{id}, Mappers.userHistoryMapper);
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }

    public DAOResponse clearRoutesById(Integer id) {
        DAOResponse<UsersHistory> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(con -> {
                PreparedStatement statement = con.prepareStatement(
                        "DELETE FROM users_history WHERE user_id = ?",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1 , id);
                return statement;
            }, keyHolder);
            result.status = HttpStatus.OK;
        }
        catch (Exception e) {
            e.printStackTrace();
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }
}
