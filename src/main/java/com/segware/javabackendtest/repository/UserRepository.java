package com.segware.javabackendtest.repository;

import com.segware.javabackendtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String userName);
}
