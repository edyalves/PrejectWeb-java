package com.projectWeb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectWeb.course.entities.User;
import com.projectWeb.course.repositories.UserRepository;
import com.projectWeb.course.services.exceptions.DatabaseException;
import com.projectWeb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//METODO UPDATE CONTENDO COM PARAMETRO ID E OBJ
	//ID PARA INDICAR O USUARIO
	//OBJ PARA CONTENDO AS ALTERAÇÕES
	public User update(Long id, User obj) {
		//getOne CRIA UMA INSTANCIA PROVISORIA SEM IR AO BD.
		User entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
