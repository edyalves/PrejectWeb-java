package com.projectWeb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectWeb.course.entities.Category;
import com.projectWeb.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	// DECLARANDO DEPENDENCIA
	@Autowired
	private CategoryRepository repository;

	// SELECT ALL USERS
	public List<Category> findAll() {
		return repository.findAll();
	}

	// SELECT USER WHERE ID
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
