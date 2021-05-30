package com.prx.be.college.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    long id;
    String firstName;
    String lastName;
    String roleName;
    String email;

    public User() {

    }

    public User(long id, String firstName, String lastName, String roleName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleName = roleName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
