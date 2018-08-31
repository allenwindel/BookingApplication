package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServiceFee;
import com.example.demo.service.ServiceFeeService;

@RestController
@RequestMapping("/reservations")
public class ServiceFeeController {

	private ServiceFeeService serviceFeeService;

	public ServiceFeeController(ServiceFeeService serviceFeeService) {
		super();
		this.serviceFeeService = serviceFeeService;
	}
	
	@GetMapping("/{reservationID}/payment")
	public Iterable<ServiceFee> getAllServiceFee(@PathVariable("reservationID") int reservationID){
		
		return serviceFeeService.findAllServiceFee();
		
	}

}
