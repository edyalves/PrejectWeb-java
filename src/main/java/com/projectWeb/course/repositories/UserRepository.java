package com.projectWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectWeb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
