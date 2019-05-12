package project.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class News {
    private Integer ID;
    private String title;
    private Date time;
    private String payload;

    @JsonCreator
    public News(
            @JsonProperty("id") Integer ID,
            @JsonProperty("title") String title,
            @JsonProperty("time") Date time,
            @JsonProperty("payload") String payload
    ) {
        this.ID = ID;
        this.title = title;
        this.time = time;
        this.payload = payload;
    }

    public News() {
        this.ID = 0;
        this.title = "";
        this.time = null;
        this.payload = "";
    }

    public Integer getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public Date getTime() {
        return time;
    }

    public String getPayload() {
        return payload;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
