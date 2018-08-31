package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

public class ReservationService {
	
	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}
	
	public Iterable<Reservation> findAllReservation(){
		
		return reservationRepository.findAll();
		
	}
	
	public Reservation findReservationByID(int id) {
		
		return reservationRepository.findById(id).get();
		
	}
	
	public Reservation saveReservation(Reservation reservation) {
		
		return reservationRepository.save(reservation);
		
	}
	
	public Iterable<Reservation> updateReservation(Iterable<Reservation> reservation){
		
		return reservationRepository.saveAll(reservation);
		
	}
	
	public void deleteReservation(List<Integer> reservationID) {
		
		for(Integer id : reservationID) {
			
			reservationRepository.deleteById(id);
			
		}
		
	}
	
	public void deleteReservation2(Reservation reservation) {
		
		reservationRepository.delete(reservation);
		
	}

}
