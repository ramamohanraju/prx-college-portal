package com.prx.be.college.model;

import java.util.Objects;

public class Subject {
    int id;
    String name;

    public Subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    private Subject(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private String name;

        private Builder() {
        }

        public Builder setId(int val) {
            id = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
