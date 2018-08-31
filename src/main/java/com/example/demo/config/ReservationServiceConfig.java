package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;

@Configuration
public class ReservationServiceConfig {
	
	@Bean
	public ReservationService reservationService(ReservationRepository reservationRepository) {
		
		return new ReservationService(reservationRepository);
		
	}

}
