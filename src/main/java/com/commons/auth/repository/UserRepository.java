package com.commons.auth.repository;

import com.commons.auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	User findByEmail(String email);
}
