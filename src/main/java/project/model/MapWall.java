package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapWall {
    private Integer ID;
    private Integer level;
    private Integer x_first;
    private Integer y_first;
    private Integer x_second;
    private Integer y_second;

    @JsonCreator
    public MapWall(
            @JsonProperty("id") Integer ID,
            @JsonProperty("level") Integer level,
            @JsonProperty("x_first") Integer x_first,
            @JsonProperty("y_first") Integer y_first,
            @JsonProperty("x_second") Integer x_second,
            @JsonProperty("y_second") Integer y_second
    ) {
        this.ID = ID;
        this.level = level;
        this.x_first = x_first;
        this.y_first = y_first;
        this.x_second = x_second;
        this.y_second = y_second;
    }

    public MapWall() {
        this.ID = 0;
        this.level = 0;
        this.x_first = 0;
        this.y_first = 0;
        this.x_second = 0;
        this.y_second = 0;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getX_first() {
        return x_first;
    }

    public Integer getY_first() {
        return y_first;
    }

    public Integer getX_second() {
        return x_second;
    }

    public Integer getY_second() {
        return y_second;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setX_first(Integer x_first) {
        this.x_first = x_first;
    }

    public void setY_first(Integer y_first) {
        this.y_first = y_first;
    }

    public void setX_second(Integer x_second) {
        this.x_second = x_second;
    }

    public void setY_second(Integer y_second) {
        this.y_second = y_second;
    }
}
