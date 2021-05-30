package com.prx.be.college.helper;

import com.prx.be.college.entity.CourseEntity;
import com.prx.be.college.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseHelper {

    public Course entityToModel(CourseEntity entity) {
        return new Course(entity.getId(), entity.getName());
    }

    public CourseEntity modelToEntity(Course model) {
        return new CourseEntity(model.getName());
    }

    public Course getModel(long id, String name) {
        return new Course(id, name);
    }

    public List<Course> getCoursesFromEntities(List<CourseEntity> entities) {
        List<Course> models = new ArrayList<>();
        entities.forEach(entity -> models.add(this.entityToModel(entity)));
        return models;
    }
}
