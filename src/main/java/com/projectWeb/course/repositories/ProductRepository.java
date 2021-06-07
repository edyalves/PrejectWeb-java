package com.projectWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectWeb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
