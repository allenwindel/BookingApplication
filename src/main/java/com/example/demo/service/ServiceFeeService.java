package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.model.ServiceFee;
import com.example.demo.repository.ServiceFeeRepository;

public class ServiceFeeService {

	private ServiceFeeRepository serviceFeeRepository;

	public ServiceFeeService(ServiceFeeRepository serviceFeeRepository) {
		super();
		this.serviceFeeRepository = serviceFeeRepository;
	}
	
	@Transactional
	public Iterable<ServiceFee> findAllServiceFee(){
		
		return serviceFeeRepository.findAll();
		
	}
	
	@Transactional
	public ServiceFee findServiceFeeByID(int id) {
		
		return serviceFeeRepository.findById(id).get();
		
	}	

}
