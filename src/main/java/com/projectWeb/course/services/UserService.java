package com.projectWeb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectWeb.course.entities.User;
import com.projectWeb.course.repositories.UserRepository;

@Service
public class UserService {

	//DECLARANDO DEPENDENCIA
	@Autowired
	private UserRepository repository;
	
	//SELECT ALL USERS
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//SELECT USER WHERE ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
