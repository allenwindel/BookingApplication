package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.ServiceFeeRepository;
import com.example.demo.service.ServiceFeeService;

@Configuration
public class ServiceFeeConfig {
	
	@Bean
	public ServiceFeeService serviceFeeService(ServiceFeeRepository serviceFeeRepository) {
		
		return new ServiceFeeService(serviceFeeRepository);
		
	}

}
