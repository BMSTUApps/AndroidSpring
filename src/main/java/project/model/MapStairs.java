package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapStairs {
    private Integer id;
    private Integer x;
    private Integer y;
    private Integer level;
    private Boolean open;
    private Integer linkedId;
    // TODO(): если расширять возможности, то добавить айди здания (влом)

    @JsonCreator
    public MapStairs (
            @JsonProperty("stairs_id") Integer id,
            @JsonProperty("x") Integer x,
            @JsonProperty("y") Integer y,
            @JsonProperty("level") Integer level,
            @JsonProperty("open") Boolean open,
            @JsonProperty("linked_id") Integer linkedId
    ) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.level = level;
        this.open = open;
        this.linkedId = linkedId;
    }

    public MapStairs() {
        this.id = 0;
        this.x = 0;
        this.y = 0;
        this.level = 0;
        this.open = false;
        this.linkedId = -1;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public void setLinkedId(Integer linkedId) {
        this.linkedId = linkedId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getLevel() {
        return level;
    }

    public Boolean getOpen() {
        return open;
    }

    public Integer getLinkedId() {
        return linkedId;
    }
}
