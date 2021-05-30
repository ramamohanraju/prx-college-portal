package com.prx.be.college.model;

import org.springframework.stereotype.Component;

@Component
public class Course {
    long id;
    String name;

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {

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
}
