package com.prx.be.college.entity;

import javax.persistence.*;

@Entity
@Table(name = "course_subjects")
public class CourseSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "corse_id", nullable = false)
    private CourseEntity course;

    public CourseSubjectEntity() {

    }

    public CourseSubjectEntity(CourseEntity course, SubjectEntity subject) {
        this.course = course;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseSubject [id=" + this.id + "]";
    }
}
