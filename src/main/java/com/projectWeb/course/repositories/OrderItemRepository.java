package com.projectWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectWeb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
