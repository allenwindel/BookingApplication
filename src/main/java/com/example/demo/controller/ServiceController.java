package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Image;
import com.example.demo.model.Service;
import com.example.demo.service.ImageService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class ServiceController {

	private ServiceService serviceService;
	private ImageService imageService;
	private TravelPackageService travelPackageService;

	public ServiceController(ServiceService serviceService, ImageService imageService,
			TravelPackageService travelPackageService) {
		super();
		this.serviceService = serviceService;
		this.imageService = imageService;
		this.travelPackageService = travelPackageService;
	}

	@GetMapping("/{travelPackageID}/services")
	public Iterable<Service> getAllService(@PathVariable("travelPackageID") int travelPackageID) {

		return travelPackageService.findTravelPackageByID(travelPackageID).getService();

		//return serviceService.findAllService();

	}

	@GetMapping("/{travelPackageID}/services/{serviceID}")
	public Service getServiceByID(@PathVariable("travelPackageID") int travelPackageID,
			@PathVariable("serviceID") int serviceID) {

		return serviceService.findServiceByID(serviceID);

	}

	@PostMapping("/{travelPackageID}/services")
	public Service saveService(@PathVariable("travelPackageID") int travelPackageID, @RequestBody Service service) {

		service = serviceService.saveService(service);
		for (Image img : service.getImages()) {

			img.setService(service);
			imageService.saveImage(img);

		}
		
		travelPackageService.findTravelPackageByID(travelPackageID).getService().add(service);
		
		return service;

	}

	@PutMapping("/{travelPackageID}/services/{serviceID}")
	public Service updateService(@PathVariable("travelPackageID") int travelPackageID,
			@PathVariable("serviceID") int serviceID, @RequestBody Service service) {

		return serviceService.saveService(service);

	}

	@PutMapping("/{travelPackageID}/services")
	public Iterable<Service> updateService2(@PathVariable("travelPackageID") int travelPackageID,
			@RequestBody Iterable<Service> service) {

		return serviceService.updateService(service);

	}

	@DeleteMapping("/{travelPackageID}/services")
	public void deleteService(@PathVariable("travelPackageID") int travelPackageID,
			@RequestParam("serviceID") List<Integer> serviceID) {

		for (Integer id : serviceID) {

			for (Image img : serviceService.findServiceByID(id).getImages()) {

				imageService.deleteImage2(img);

			}

			serviceService.deleteService2(serviceService.findServiceByID(id));

		}

	}

	@DeleteMapping("/{travelPackageID}/services/{serviceID}")
	public void deleteService2(@PathVariable("travelPackageID") int travelPackageID,
			@PathVariable("serviceID") int serviceID) {

		serviceService.deleteService2(serviceService.findServiceByID(serviceID));

	}

}
