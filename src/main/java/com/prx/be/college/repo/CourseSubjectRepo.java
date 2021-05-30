package com.prx.be.college.repo;

import com.prx.be.college.entity.CourseSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSubjectRepo extends JpaRepository<CourseSubjectEntity, Long> {
    List<CourseSubjectEntity> findByCourse(long courseId);
    List<CourseSubjectEntity> findByCourse_Name(String courseName);
    List<CourseSubjectEntity> findBySubject(long subjectId);
    List<CourseSubjectEntity> findBySubject_Name(String subjectName);
    List<CourseSubjectEntity> findByCourse_IdAndSubject_Id(long courseId, long subjectId);
    List<CourseSubjectEntity> findByCourse_NameAndSubject_Name(String courseName, String subjectName);
}
