package com.prx.be.college.controller;

import com.prx.be.college.entity.ContentEntity;
import com.prx.be.college.model.Content;
import com.prx.be.college.repo.ContentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContentController {

    private final ContentRepo contentRepo;

    public ContentController(ContentRepo contentRepo) {
        this.contentRepo = contentRepo;
    }

    @PostMapping(value = "/contents")
    public Content create(@RequestBody Content content) {
        ContentEntity entity = new ContentEntity();
        contentRepo.save(entity);
        return content;
    }

    @GetMapping(value = "/contents")
    public List<Content> get(@RequestParam(value = "name", required = false) String name) {
        List<ContentEntity> entities = contentRepo.findAll();
        List<Content> contents = new ArrayList<>();
        for(ContentEntity entity : entities) {
            contents.add(new Content(entity.getId(), entity.getName(), entity.getType(), entity.getCourseSubjectEntity().getId(), entity.getTagsEntity().getId()));
        }

        return contents;
    }

    @GetMapping(value = "/contents/{id}")
    public Content get(@PathVariable long id) {
        ContentEntity entity = contentRepo.findById(id).get();
        return new Content(entity.getId(), entity.getName(), entity.getType(), entity.getCourseSubjectEntity().getId(), entity.getTagsEntity().getId());
    }
}
