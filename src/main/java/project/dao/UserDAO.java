package project.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import project.model.DAOResponse;
import project.model.User;

import java.sql.PreparedStatement;

@Service
public class UserDAO {

    private final JdbcTemplate template;

    public UserDAO(JdbcTemplate template) {
        this.template = template;
    }

    public DAOResponse createUser(User user) {
        DAOResponse<User> result = new DAOResponse<>();
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            template.update(connection -> {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO  \"user\" (login, password) VALUES(?, ?);",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                return statement;
            },keyHolder);
            result.body = user;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.CONFLICT;
        }
        return result;
    }

    public DAOResponse getUserByID(Integer id) {
        DAOResponse<User> result = new DAOResponse<>();
        try {
            final User user = template.queryForObject("SELECT * FROM \"user\" WHERE id = ?",
                    new Object[]{id}, Mappers.userMapper);
            result.body = user;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }

    public DAOResponse checkUser(User user) {
        DAOResponse<User> result = new DAOResponse<>();
        try {
            final User user_db = template.queryForObject("SELECT * FROM \"user\" WHERE login = ?",
                    new Object[]{user.getLogin()}, Mappers.userMapper);

            if (!user_db.getPassword().equals(user.getPassword())) {
                result.body = null;
                result.status = HttpStatus.CONFLICT;

                return result;
            }

            result.body = user_db;
            result.status = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            result.body = null;
            result.status = HttpStatus.NOT_FOUND;
        }
        return result;
    }


}