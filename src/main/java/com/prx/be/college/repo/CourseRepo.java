package com.prx.be.college.repo;

import com.prx.be.college.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByName(String name);
}
