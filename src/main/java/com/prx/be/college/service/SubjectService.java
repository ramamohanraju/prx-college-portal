package com.prx.be.college.service;

import com.prx.be.college.dao.SubjectDao;
import com.prx.be.college.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public Subject create(Subject subject) {
        return subjectDao.save(subject);
    }

    public List<Subject> get() {
        return subjectDao.getAllSubjects();
    }

    public Subject get(long id) {
        return subjectDao.getById(id);
    }

    public List<Subject> getByName(String name) {
        return subjectDao.getSubjectsByName(name);
    }
}
