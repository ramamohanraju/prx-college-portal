package com.prx.be.college.helper;

import com.prx.be.college.entity.SubjectEntity;
import com.prx.be.college.model.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectHelper {

    public Subject entityToModel(SubjectEntity subjectEntity) {
        return Subject.newBuilder()
                .setId(subjectEntity.getId())
                .setName(subjectEntity.getName())
                .build();
    }

    public SubjectEntity modelToEntity(Subject subject) {
        return new SubjectEntity(subject.getName());
    }

    public Subject getModel(long id, String name) {
        return Subject.newBuilder()
                .setId(id)
                .setName(name)
                .build();
    }

    public List<Subject> getSubjectsFromEntities(List<SubjectEntity> entities) {
        List<Subject> subjects = new ArrayList<>();
        entities.forEach(entity -> subjects.add(this.entityToModel(entity)));
        return subjects;
    }
}
