package com.projectWeb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectWeb.course.entities.Order;
import com.projectWeb.course.entities.User;
import com.projectWeb.course.repositories.OrderRepository;
import com.projectWeb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//DECLARANDO DEPENDENCIA
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2099-06-20T00:00:05Z"), u1);
		Order o2 = new Order(null, Instant.parse("2150-06-20T00:00:05Z"), u2);
		Order o3 = new Order(null, Instant.parse("2200-06-20T00:00:05Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}