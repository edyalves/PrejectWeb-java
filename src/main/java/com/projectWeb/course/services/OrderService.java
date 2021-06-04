package com.projectWeb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectWeb.course.entities.Order;
import com.projectWeb.course.repositories.OrderRepository;

@Service
public class OrderService {

	//DECLARANDO DEPENDENCIA
	@Autowired
	private OrderRepository repository;
	
	//SELECT ALL USERS
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	//SELECT USER WHERE ID
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
