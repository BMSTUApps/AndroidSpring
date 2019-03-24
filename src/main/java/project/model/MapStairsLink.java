package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapStairsLink {
    private Integer id;
    private Integer idFrom;
    private Integer idTo;
    private Integer weight;
    private Boolean open;

    @JsonCreator
    public MapStairsLink(
            @JsonProperty("id") Integer id,
            @JsonProperty("idFrom") Integer idFrom,
            @JsonProperty("idTo") Integer idTo,
            @JsonProperty("weight") Integer weight,
            @JsonProperty("open") Boolean open
    ) {
        this.id = id;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.weight = weight;
        this.open = open;
    }

    public MapStairsLink() {
        this.id = 0;
        this.idFrom = 0;
        this.idTo = 0;
        this.weight = 0;
        this.open = false;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdFrom(Integer idFrom) {
        this.idFrom = idFrom;
    }

    public void setIdTo(Integer idTo) {
        this.idTo = idTo;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdFrom() {
        return idFrom;
    }

    public Integer getIdTo() {
        return idTo;
    }

    public Integer getWeight() {
        return weight;
    }

    public Boolean getOpen() {
        return open;
    }
}
