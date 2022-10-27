package com.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoes.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}
