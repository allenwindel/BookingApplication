package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FeedbackService;

@RestController
@RequestMapping("/travel-packages")
public class FeedbackController {
	
	private FeedbackService feedbackService;

	public FeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	}
	
	

}
