package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;

@Configuration
public class FeedbackServiceConfig {
	
	@Bean
	public FeedbackService feedbackService(FeedbackRepository feedbackRepository) {
		
		return new FeedbackService(feedbackRepository);
		
	}

}
