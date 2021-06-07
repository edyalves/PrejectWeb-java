package com.projectWeb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectWeb.course.entities.Category;
import com.projectWeb.course.entities.Order;
import com.projectWeb.course.entities.Product;
import com.projectWeb.course.entities.User;
import com.projectWeb.course.entities.enums.OrderStatus;
import com.projectWeb.course.repositories.CategoryRepository;
import com.projectWeb.course.repositories.OrderRepository;
import com.projectWeb.course.repositories.ProductRepository;
import com.projectWeb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//DECLARANDO DEPENDENCIA
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository produtcRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2099-06-20T00:00:05Z"), OrderStatus.WAITTING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2150-06-20T00:00:05Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2200-06-20T00:00:05Z"), OrderStatus.DELIVERED, u1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");	
		
		Product p1 = new Product(null, "O Rei dos Aneis", "Description p1", 90.5, "");
		Product p2 = new Product(null, "Os Incriveis", "Description p2", 100.5, "");	
		Product p3 = new Product(null, "Madagascar", "Description p3", 80.5, "");	
		Product p4 = new Product(null, "IT", "Description p4", 70.5, "");	
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtcRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
	}
}