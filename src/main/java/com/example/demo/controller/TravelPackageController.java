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
import com.example.demo.model.TravelPackage;
import com.example.demo.service.ImageService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private TravelPackageService travelPackageService;
	private ServiceService serviceService;
	private ImageService imageService;

	public TravelPackageController(TravelPackageService travelPackageService, ServiceService serviceService,
			ImageService imageService) {
		super();
		this.travelPackageService = travelPackageService;
		this.serviceService = serviceService;
		this.imageService = imageService;
	}

	@GetMapping
	public Iterable<TravelPackage> getAllTravelPackage() {

		return travelPackageService.findAllTravelPackage();

	}

	@GetMapping("/{travelPackageID}")
	public TravelPackage getTravelPackageByID(@PathVariable("travelPackageID") int travelPackageID) {

		return travelPackageService.findTravelPackageByID(travelPackageID);

	}

	@PostMapping
	public TravelPackage saveTravelPackage(@RequestBody TravelPackage travelPackage) {
		
		travelPackage = travelPackageService.saveTravelPackage(travelPackage);
		for(Service srv : travelPackage.getService()) {
			srv.setTravelPackage(travelPackage);
			serviceService.saveService(srv);
		}
		for(Image img : travelPackage.getImage()) {
			img.setTravelPackage(travelPackage);
			imageService.saveImage(img);
		}
		
		return travelPackage;
		
	}
	
	@PutMapping("/{travelPackageID")
	public TravelPackage updateTravelPackage(@PathVariable("travelPackageID") int travelPackageID,@RequestBody TravelPackage travelPackage) {
		
		travelPackage.setTravelPackageID(travelPackageID);
		return travelPackageService.saveTravelPackage(travelPackage);
		
	}
	
	@PutMapping
	public Iterable<TravelPackage> updateTravelPackage2(@RequestBody Iterable<TravelPackage> travelPackage){
		
		return travelPackageService.updateTravelPackage(travelPackage);
		
	}
	
	@DeleteMapping
	public void deleteTravelPackage(@RequestParam("travelPackageID") List<Integer> travelPackageID) {
		
		for(Integer id : travelPackageID) {
			
			for(Service src : travelPackageService.findTravelPackageByID(id).getService()) {
				
				serviceService.deleteService2(src);
				
			}
			
			for(Image img : travelPackageService.findTravelPackageByID(id).getImage()) {
				
				imageService.deleteImage2(img);
				
			}
			
			travelPackageService.deleteTravelPackage2(travelPackageService.findTravelPackageByID(id));
			
		}
		
	}
	
	@DeleteMapping("/{travelPackageID}")
	public void deleteTravelPackage2(@PathVariable("travelPackageID") int travelPackageID) {
		
		for(Service src : travelPackageService.findTravelPackageByID(travelPackageID).getService()) {
			
			serviceService.deleteService2(src);
			
		}
		
		for(Image img : travelPackageService.findTravelPackageByID(travelPackageID).getImage()) {
			
			imageService.deleteImage2(img);
			
		}
		
		travelPackageService.deleteTravelPackage2(travelPackageService.findTravelPackageByID(travelPackageID));
		
	}

}
