package com.prx.be.college.controller;

import com.prx.be.college.entity.UserEntity;
import com.prx.be.college.model.User;
import com.prx.be.college.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        UserEntity entity = new UserEntity();
        entity = userRepo.save(entity);
        return new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getRoleName(), entity.getEmail());
    }

    @GetMapping(value = "/users")
    public List<User> get(@RequestParam(value = "name", required = false) String name) {
        List<UserEntity> entities = userRepo.findAll();
        List<User> users = new ArrayList<>();
        for(UserEntity entity : entities) {
            users.add(new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getRoleName(), entity.getEmail()));
        }

        return users;
    }

    @GetMapping(value = "/users/{id}")
    public User get(@PathVariable long id) {
        UserEntity entity = userRepo.findById(id).get();
        return new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getRoleName(), entity.getEmail());
    }
}
