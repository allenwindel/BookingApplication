package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

	@Transactional
	public Iterable<TravelPackage> findAllTravelPackage() {

		return travelPackageRepository.findAll();

	}

	@Transactional
	public TravelPackage findTravelPackageByID(int ID) {

		return travelPackageRepository.findById(ID).get();

	}

	@Transactional
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {

		return travelPackageRepository.save(travelPackage);

	}
	
	@Transactional
	public Iterable<TravelPackage> updateTravelPackage(Iterable<TravelPackage> travelPackage){
		
		return travelPackageRepository.saveAll(travelPackage);
		
	}

	@Transactional
	public void deleteTravelPackage(List<Integer> travelPackageID) {

		for (Integer id : travelPackageID) {

			travelPackageRepository.deleteById(id);

		}

	}

	@Transactional
	public void deleteTravelPackage2(TravelPackage travelPackage) {

		travelPackageRepository.delete(travelPackage);

	}

}
