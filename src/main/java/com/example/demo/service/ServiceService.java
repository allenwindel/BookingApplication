package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;

public class ServiceService {

	private ServiceRepository serviceRepository;

	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	@Transactional
	public Iterable<Service> findAllService() {

		return serviceRepository.findAll();

	}

	@Transactional
	public Service findServiceByID(int ID) {

		return serviceRepository.findById(ID).get();

	}

	@Transactional
	public Service saveService(Service service) {

		return serviceRepository.save(service);

	}
	
	@Transactional
	public Iterable<Service> updateService(Iterable<Service> service){
		
		return serviceRepository.saveAll(service);
		
	}

	@Transactional
	public void deleteService(List<Integer> serviceID) {

		for (Integer id : serviceID) {

			serviceRepository.deleteById(id);

		}

	}

	@Transactional
	public void deleteService2(Service service) {

		serviceRepository.delete(service);

	}

}
