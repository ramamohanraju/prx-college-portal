package com.prx.be.college.repo;

import com.prx.be.college.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagsRepo extends JpaRepository<TagsEntity, Long> {
    List<TagsEntity> findByTagsContains(String tag);
    List<TagsEntity> findByTags(String tags);
}
