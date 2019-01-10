package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersHistory {
    private Integer id;
    private Integer user_id;
    private Integer point_from;
    private Integer point_to;

    @JsonCreator
    public UsersHistory(
            @JsonProperty("id") Integer id,
            @JsonProperty("user_id") Integer user_id,
            @JsonProperty("point_from") Integer point_from,
            @JsonProperty("point_to") Integer point_to
    ) {
        this.id = id;
        this.user_id = user_id;
        this.point_from = point_from;
        this.point_to = point_to;
    }

    public UsersHistory() {
        this.id = 0;
        this.user_id = 0;
        this.point_from = 0;
        this.point_to = 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setPoint_from(Integer point_from) {
        this.point_from = point_from;
    }

    public void setPoint_to(Integer point_to) {
        this.point_to = point_to;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getPoint_from() {
        return point_from;
    }

    public Integer getPoint_to() {
        return point_to;
    }
}
