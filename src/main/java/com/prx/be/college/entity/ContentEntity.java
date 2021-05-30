package com.prx.be.college.entity;

import javax.persistence.*;

@Entity
@Table(name = "contents")
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "course_subject_id", nullable = false)
    private CourseSubjectEntity courseSubjectEntity;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private TagsEntity tagsEntity;

    public ContentEntity() {

    }

    public ContentEntity(String name, String url, CourseSubjectEntity courseSubjectEntity, String type, TagsEntity tagsEntity) {
        this.name = name;
        this.url = url;
        this.courseSubjectEntity = courseSubjectEntity;
        this.type = type;
        this.tagsEntity = tagsEntity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CourseSubjectEntity getCourseSubjectEntity() {
        return courseSubjectEntity;
    }

    public void setCourseSubjectEntity(CourseSubjectEntity courseSubjectEntity) {
        this.courseSubjectEntity = courseSubjectEntity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TagsEntity getTagsEntity() {
        return tagsEntity;
    }

    public void setTagsEntity(TagsEntity tagsEntity) {
        this.tagsEntity = tagsEntity;
    }

    public SubjectEntity getSubjectEntity() {
        return courseSubjectEntity == null ? null : courseSubjectEntity.getSubject();
    }

    public CourseEntity getCourseEntity() {
        return courseSubjectEntity == null ? null : courseSubjectEntity.getCourse();
    }

    @Override
    public String toString() {
        return "Content [id=" + this.id + ", name=" + this.name + "]";
    }
}
