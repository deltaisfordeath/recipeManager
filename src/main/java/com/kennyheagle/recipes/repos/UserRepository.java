package com.kennyheagle.recipes.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kennyheagle.recipes.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}