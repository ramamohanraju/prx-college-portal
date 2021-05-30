package com.prx.be.college.controller;

import com.prx.be.college.entity.CourseEntity;
import com.prx.be.college.entity.CourseSubjectEntity;
import com.prx.be.college.entity.SubjectEntity;
import com.prx.be.college.model.Course;
import com.prx.be.college.model.CourseSubject;
import com.prx.be.college.repo.CourseRepo;
import com.prx.be.college.repo.CourseSubjectRepo;
import com.prx.be.college.repo.SubjectRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private final CourseRepo courseRepo;
    private final SubjectRepo subjectRepo;
    private final CourseSubjectRepo courseSubjectRepo;

    public CourseController(CourseRepo courseRepo, SubjectRepo subjectRepo, CourseSubjectRepo courseSubjectRepo) {
        this.courseRepo = courseRepo;
        this.subjectRepo = subjectRepo;
        this.courseSubjectRepo = courseSubjectRepo;
    }

    @PostMapping(value = "/courses")
    public Course create(@RequestBody Course course) {
        CourseEntity entity = new CourseEntity(course.getName());
        entity = courseRepo.save(entity);
        return new Course(entity.getId(), entity.getName());
    }

    @GetMapping(value = "/courses")
    public List<Course> get(@RequestParam(value = "name", required = false) String name) {
        List<CourseEntity> entities = courseRepo.findAll();
        List<Course> courses = new ArrayList<>();
        for(CourseEntity course : entities) {
            courses.add(new Course(course.getId(), course.getName()));
        }

        return courses;
    }

    @GetMapping(value = "/courses/{id}")
    public Course get(@PathVariable long id) {
        CourseEntity entity = courseRepo.findById(id).get();
        return new Course(entity.getId(), entity.getName());
    }

    @PatchMapping(value = "/courses/{id}")
    public CourseSubject addSubject(@PathVariable long id, @RequestParam(value = "subject", required = true) String subjectName) {
        CourseEntity course = courseRepo.findById(id).get();
        SubjectEntity subject = subjectRepo.findByName(subjectName).get(0);
        CourseSubjectEntity entity = courseSubjectRepo.save(new CourseSubjectEntity(course, subject));
        return new CourseSubject(entity.getId(), entity.getCourse().getId(), entity.getSubject().getId());
    }

}
