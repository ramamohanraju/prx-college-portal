package com.prx.be.college.init;

import com.prx.be.college.entity.*;
import com.prx.be.college.helper.Constants;
import com.prx.be.college.repo.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataRunner implements ApplicationRunner {

    private final UserRepo userRepo;
    private final CourseRepo courseRepo;
    private final SubjectRepo subjectRepo;
    private final CourseSubjectRepo courseSubjectRepo;
    private final TagsRepo tagsRepo;
    private final ContentRepo contentRepo;

    public SeedDataRunner(UserRepo userRepo, CourseRepo courseRepo, SubjectRepo subjectRepo, CourseSubjectRepo courseSubjectRepo, TagsRepo tagsRepo, ContentRepo contentRepo) {
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
        this.subjectRepo = subjectRepo;
        this.courseSubjectRepo = courseSubjectRepo;
        this.tagsRepo = tagsRepo;
        this.contentRepo = contentRepo;
    }


    public void run(ApplicationArguments args) {
        this.seedUsers();
        this.seedCourses();
        this.seedSubjectsAndCourseSubjects();
        this.seedTags();
        this.seedContents();
    }

    private void seedUsers() {
        this.createInstructor("Super", "User", "superuser@prx.com");
        this.createInstructor("Instructor1", "I1", "instructor1@prx.com");
        this.createInstructor("Instructor2", "I2", "instructor2@prx.com");
        this.createStudent("Student1", "S1", "student1@prx.com");
        this.createStudent("Student2", "S2", "student2@prx.com");
    }

    private void seedCourses() {
        this.createCourse("CSE");
        this.createCourse("IT");
        this.createCourse("ECE");
    }

    private void seedSubjectsAndCourseSubjects() {
        this.createSubjectAndLinkCourses("Design patterns", "CSE", "IT");
        this.createSubjectAndLinkCourses("Electronics", "ECE");
        this.createSubjectAndLinkCourses("Computer hardware", "IT");
        this.createSubjectAndLinkCourses("Computer graphics", "CSE");
        this.createSubjectAndLinkCourses("Mathematics for CS", "ECE", "CSE", "IT");
        this.createSubjectAndLinkCourses("Java", "CSE");
    }

    private void seedTags() {
        this.createTags("computer");
        this.createTags("electronics");
        this.createTags("graphics");
        this.createTags("computer,graphics");
        this.createTags("computer,security");
    }

    private void seedContents() {
        String url = "https://www.youtube.com/watch?v=CnailTcJV_U"; // can be replaced with any cloud object storage
        this.createVideo("Lecture1 - architecture", url, "CSE~Design patterns", "computer");
        this.createVideo("Lecture2 - Mathematics", url, "IT~Mathematics for CS", "computer");
        this.createVideo("Lecture3 - Electronics", url, "ECE~Electronics", "electronics");
        this.createWebinar("Webinar1 - java", url, "CSE~Java", "computer");
        this.createWebinar("Webinar2 - security", url, "IT~Computer hardware", "computer,security");
    }

    private void createVideo(String name, String url, String courseSubject, String tags) {
        createContent(name, url, courseSubject, Constants.CONTENT_VIDEO, tags);
    }

    private void createWebinar(String name, String url, String courseSubject, String tags) {
        createContent(name, url, courseSubject, Constants.CONTENT_VIDEO, tags);
    }

    private void createContent(String name, String url, String courseSubject, String type, String tags) {
        String[] courseSubjectStr = courseSubject.split("~");
        CourseSubjectEntity courseSubjectEntity = courseSubjectRepo.findByCourse_NameAndSubject_Name(courseSubjectStr[0], courseSubjectStr[1]).get(0);

        TagsEntity tagsEntity = tagsRepo.findByTags(tags).get(0);
        contentRepo.save(new ContentEntity(name, url, courseSubjectEntity, type, tagsEntity));
    }

    private void createTags(String tags) {
        tagsRepo.save(new TagsEntity(tags));
    }

    private void createCourseSubject(String courseName, String subjectName) {
        CourseEntity course = courseRepo.findByName(courseName).get(0);
        SubjectEntity subject = subjectRepo.findByName(subjectName).get(0);
        courseSubjectRepo.save(new CourseSubjectEntity(course, subject));
    }

    private void createSubjectAndLinkCourses(String subjectName, String... courses) {
        subjectRepo.save(new SubjectEntity(subjectName));
        for(String course: courses) {
            createCourseSubject(course, subjectName);
        }
    }

    private void createCourse(String name) {
        courseRepo.save(new CourseEntity(name));
    }

    private void createStudent(String firstName, String lastName, String email) {
        createUser(firstName, lastName, email, Constants.ROLE_STUDENT);
    }

    private void createInstructor(String firstName, String lastName, String email) {
        createUser(firstName, lastName, email, Constants.ROLE_INSTRUCTOR);
    }

    private void createUser(String firstName, String lastName, String email, String userType) {
        userRepo.save(new UserEntity(firstName, lastName, email, userType));
    }

}
