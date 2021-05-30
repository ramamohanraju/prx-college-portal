package com.prx.be.college.repo;

import com.prx.be.college.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByRoleName(String roleName);
}
