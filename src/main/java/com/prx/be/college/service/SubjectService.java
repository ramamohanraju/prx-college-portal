package com.prx.be.college.service;

import com.prx.be.college.model.Subject;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService {

    public Subject create(Subject subject) {
        return Subject.newBuilder()
                .setId(1)
                .setName(subject.getName())
                .build();
    }

    public List<Subject> get() {
        return Arrays.asList(
                Subject.newBuilder()
                        .setId(1)
                        .setName("sample name1")
                        .build(),
                Subject.newBuilder()
                        .setId(2)
                        .setName("sample name2")
                        .build()
        );
    }

    public Subject get(int id) {
        return Subject.newBuilder()
                .setId(id)
                .setName("sample name " + id)
                .build();
    }
}
