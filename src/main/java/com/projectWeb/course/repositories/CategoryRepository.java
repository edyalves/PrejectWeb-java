package com.projectWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectWeb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
