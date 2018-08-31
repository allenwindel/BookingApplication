package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;

public class ServiceService {

	private ServiceRepository serviceRepository;

	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	public Iterable<Service> findAllService() {

		return serviceRepository.findAll();

	}

	public Service findServiceByID(int ID) {

		return serviceRepository.findById(ID).get();

	}

	public Service saveService(Service service) {

		return serviceRepository.save(service);

	}
	
	public Iterable<Service> updateService(Iterable<Service> service){
		
		return serviceRepository.saveAll(service);
		
	}

	public void deleteService(List<Integer> serviceID) {

		for (Integer id : serviceID) {

			serviceRepository.deleteById(id);

		}

	}

	public void deleteService2(Service service) {

		serviceRepository.delete(service);

	}

}
