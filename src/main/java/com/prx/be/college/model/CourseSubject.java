package com.prx.be.college.model;

import org.springframework.stereotype.Component;

@Component
public class CourseSubject {
    long id;
    long courseId;
    long subjectId;

    public CourseSubject(long id, long courseId, long subjectId) {
        this.id = id;
        this.courseId = courseId;
        this.subjectId = subjectId;
    }

    public CourseSubject() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
}
