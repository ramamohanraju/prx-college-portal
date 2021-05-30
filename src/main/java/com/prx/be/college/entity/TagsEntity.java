package com.prx.be.college.entity;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tags")
    private String tags;

    public TagsEntity() {

    }

    public TagsEntity(String tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Tags [id=" + this.id + ", tags=" + this.tags + "]";
    }
}
