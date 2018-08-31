package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

public class ReservationService {
	
	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}
	
	@Transactional
	public Iterable<Reservation> findAllReservation(){
		
		return reservationRepository.findAll();
		
	}
	
	@Transactional
	public Reservation findReservationByID(int id) {
		
		return reservationRepository.findById(id).get();
		
	}
	
	@Transactional
	public Reservation saveReservation(Reservation reservation) {
		
		return reservationRepository.save(reservation);
		
	}
	
	@Transactional
	public Iterable<Reservation> updateReservation(Iterable<Reservation> reservation){
		
		return reservationRepository.saveAll(reservation);
		
	}
	
	@Transactional
	public void deleteReservation(List<Integer> reservationID) {
		
		for(Integer id : reservationID) {
			
			reservationRepository.deleteById(id);
			
		}
		
	}
	
	@Transactional
	public void deleteReservation2(Reservation reservation) {
		
		reservationRepository.delete(reservation);
		
	}

}
