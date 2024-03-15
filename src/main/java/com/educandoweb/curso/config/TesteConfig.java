package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Client;
import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.entities.enums.OrderStatus;
import com.educandoweb.curso.repositories.ClientRepository;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Rafael Nunes", "rafa.nuns17@gmail.com", "(91)99120-0793", "03310103");
		User u4 = new User(null, "Aynara Magalhaes", "aynara.magalhaes@gmail.com", "(91)99120-0793", "03310103");
		
		Client c1 = new Client(null, "Maria Brown", "04603528221", "maria@gmail.com"); 
		Client c2 = new Client(null, "Alex Green", "01403562752", "alex@gmail.com");
		Client c3 = new Client(null, "Rafael Nunes", "00000000000", "rafa.nuns17@gmail.com");
		Client c4 = new Client(null, "Aynara Magalhaes", "", "aynara.magalhaes@gmail.com");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
