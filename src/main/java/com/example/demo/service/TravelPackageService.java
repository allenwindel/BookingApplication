package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

	public Iterable<TravelPackage> findAllTravelPackage() {

		return travelPackageRepository.findAll();

	}

	public TravelPackage findTravelPackageByID(int ID) {

		return travelPackageRepository.findById(ID).get();

	}

	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {

		return travelPackageRepository.save(travelPackage);

	}
	
	public Iterable<TravelPackage> updateTravelPackage(Iterable<TravelPackage> travelPackage){
		
		return travelPackageRepository.saveAll(travelPackage);
		
	}

	public void deleteTravelPackage(List<Integer> travelPackageID) {

		for (Integer id : travelPackageID) {

			travelPackageRepository.deleteById(id);

		}

	}

	public void deleteTravelPackage2(TravelPackage travelPackage) {

		travelPackageRepository.delete(travelPackage);

	}

}
