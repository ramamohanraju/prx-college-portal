package com.prx.be.college.dao;

import com.prx.be.college.entity.SubjectEntity;
import com.prx.be.college.helper.SubjectHelper;
import com.prx.be.college.model.Subject;
import com.prx.be.college.repo.SubjectRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectDao {
    private final SubjectRepo subjectRepo;
    private final SubjectHelper subjectHelper;

    public SubjectDao(SubjectRepo subjectRepo, SubjectHelper subjectHelper) {
        this.subjectRepo = subjectRepo;
        this.subjectHelper = subjectHelper;
    }

    public List<Subject> getAllSubjects() {
        return subjectHelper.getSubjectsFromEntities(subjectRepo.findAll());
    }

    public Subject getById(long id) {
        return subjectHelper.entityToModel(subjectRepo.getById(id));
    }

    public Subject save(Subject subject) {
        SubjectEntity entity = subjectRepo.save(subjectHelper.modelToEntity(subject));
        return subjectHelper.entityToModel(entity);
    }

    public List<Subject> getSubjectsByName(String name) {
        List<SubjectEntity> entities = subjectRepo.findByName(name);
        return subjectHelper.getSubjectsFromEntities(entities);
    }
}
