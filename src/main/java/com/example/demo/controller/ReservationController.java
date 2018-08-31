package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.model.Reservation;
import com.example.demo.model.Service;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private ReservationService reservationService;
	private CustomerService customerService;

	public ReservationController(ReservationService reservationService,CustomerService customerService) {
		super();
		this.reservationService = reservationService;
		this.customerService = customerService;
	}

	@GetMapping
	public Iterable<Reservation> getAllReservation() {

		return reservationService.findAllReservation();

	}

	@GetMapping("/{reservationID}")
	public Reservation getReservationByID(int id) {

		return reservationService.findReservationByID(id);

	}

	@PostMapping
	public Reservation saveReservation(@RequestBody Reservation reservation) {

		reservation = reservationService.saveReservation(reservation);
		List<Service> service = new ArrayList<Service>();
		
		for(Service src : reservation.getService()) {
			
			service.add(src);
			
		}
		
		reservation.setService(service);

		return reservation;

	}

	@PutMapping("/{reservationID}")
	public Reservation updateReservation(@PathVariable("reservationID") int reservationID,
			@RequestBody Reservation reservation) {

		reservation.setReservationID(reservationID);
		return reservationService.saveReservation(reservation);

	}

	@PutMapping
	public Iterable<Reservation> updateReservation2(
			@RequestParam("reservationID") Iterable<Reservation> reservationID) {

		return reservationService.updateReservation(reservationID);

	}

	@DeleteMapping
	public void deleteReservation(@RequestParam("reservationID") List<Integer> reservationID) {

		for (Integer id : reservationID) {

			reservationService.deleteReservation2(reservationService.findReservationByID(id));

		}

	}

	@DeleteMapping("/{reservationID}")
	public void deleteReservation2(@PathVariable("reservationID") int reservationID) {

		reservationService.deleteReservation2(reservationService.findReservationByID(reservationID));

	}

}
