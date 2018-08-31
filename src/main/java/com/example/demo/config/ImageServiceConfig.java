package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.ImageRepository;
import com.example.demo.service.ImageService;

@Configuration
public class ImageServiceConfig {

	@Bean
	public ImageService imageService(ImageRepository imageRepository) {
		
		return new ImageService(imageRepository);
		
	}
	
}
