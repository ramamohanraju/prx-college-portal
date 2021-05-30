package com.prx.be.college.controller;

import com.prx.be.college.entity.TagsEntity;
import com.prx.be.college.model.Tag;
import com.prx.be.college.repo.TagsRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TagController {

    private final TagsRepo tagsRepo;

    public TagController(TagsRepo tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    @PostMapping(value = "/tags")
    public Tag create(@RequestBody Tag tags) {
        TagsEntity entity = new TagsEntity(tags.getTags());
        entity = tagsRepo.save(entity);
        return new Tag(entity.getId(), entity.getTags());
    }

    @GetMapping(value = "/tags")
    public List<Tag> get(@RequestParam(value = "name", required = false) String name) {
        List<TagsEntity> entities = tagsRepo.findAll();
        List<Tag> tagss = new ArrayList<>();
        for(TagsEntity entity : entities) {
            tagss.add(new Tag(entity.getId(), entity.getTags()));
        }

        return tagss;
    }

    @GetMapping(value = "/tags/{id}")
    public Tag get(@PathVariable long id) {
        TagsEntity entity = tagsRepo.findById(id).get();
        return new Tag(entity.getId(), entity.getTags());
    }
}
