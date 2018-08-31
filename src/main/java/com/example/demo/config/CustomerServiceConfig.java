package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Configuration
public class CustomerServiceConfig {
	
	@Bean
	public CustomerService customerService(CustomerRepository customerRepository) {
		
		return new CustomerService(customerRepository);
		
	}

}
