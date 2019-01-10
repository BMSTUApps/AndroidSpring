package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private Integer id;
    private String login;
    private String password;


    @JsonCreator
    public User(
            @JsonProperty("id") Integer id,
            @JsonProperty("login") String login,
            @JsonProperty("password") String password
    ) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User() {
        this.id = 0;
        this.login = "created";
        this.password = "created";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


