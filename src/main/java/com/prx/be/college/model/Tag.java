package com.prx.be.college.model;

import org.springframework.stereotype.Component;

@Component
public class Tag {
    long id;
    String tags;

    public Tag() {

    }

    public Tag(long id, String tags) {
        this.id = id;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
