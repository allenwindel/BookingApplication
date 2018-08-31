package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.service.TravelPackageService;

@Configuration
public class TravelPackageServiceConfig {

	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository) {
		
		return new TravelPackageService(travelPackageRepository);
		
	}
	
}
