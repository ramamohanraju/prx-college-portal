package com.prx.be.college.repo;

import com.prx.be.college.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepo extends JpaRepository<ContentEntity, Long> {
    List<ContentEntity> findByName(String name);
}
