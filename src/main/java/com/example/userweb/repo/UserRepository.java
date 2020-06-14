package com.example.userweb.repo;

import java.util.Optional;

import com.example.userweb.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUid(String uid);
}