package com.prx.be.college.repo;

import com.prx.be.college.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo  extends JpaRepository<SubjectEntity, Long> {
    List<SubjectEntity> findByName(String name);
}
