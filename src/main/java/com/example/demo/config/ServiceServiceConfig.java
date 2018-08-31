package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceService;

@Configuration
public class ServiceServiceConfig {
	
	@Bean
	public ServiceService serviceService(ServiceRepository serviceRepository) {
		
		return new ServiceService(serviceRepository);
		
	}

}
