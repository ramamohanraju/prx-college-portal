package com.prx.be.college.model;

import org.springframework.stereotype.Component;

@Component
public class Content {
    long id;
    String name;
    String type;
    long courseSubjectId;
    long tagId;

    public Content() {

    }

    public Content(long id, String name, String type, long courseSubjectId, long tagId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.courseSubjectId = courseSubjectId;
        this.tagId = tagId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCourseSubjectId() {
        return courseSubjectId;
    }

    public void setCourseSubjectId(long courseSubjectId) {
        this.courseSubjectId = courseSubjectId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
