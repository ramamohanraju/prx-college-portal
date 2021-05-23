package com.prx.be.college.controller;

import com.prx.be.college.ApiException;
import com.prx.be.college.model.Subject;
import com.prx.be.college.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(value = "/subjects")
    public Subject create(@RequestBody Subject subject) {
        try{
            return subjectService.create(subject);
        } catch (RuntimeException exception) {
            LOGGER.error("error while creating subject - {}", exception.getMessage());
            throw new ApiException("error while creating subject", exception);
        }
    }

    @GetMapping(value = "/subjects")
    public List<Subject> get(@RequestParam(value = "name", required = false) String name) {
        try{
            if(name == null || name.isEmpty()) {
                return subjectService.get();
            }
            return subjectService.getByName(name);
        } catch (RuntimeException exception) {
            LOGGER.error("error while getting all subjects - {}", exception.getMessage());
            throw new ApiException("error while getting all subjects", exception);
        }
    }

    @GetMapping(value = "/subjects/{id}")
    public Subject get(@PathVariable int id) {
        try{
            return subjectService.get(id);
        } catch (RuntimeException exception) {
            LOGGER.error("error while getting subject with id {} - {}", id, exception.getMessage());
            throw new ApiException("error while getting subject", exception);
        }
    }

}
