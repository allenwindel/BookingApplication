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

import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	private ReservationService reservationService;

	public CustomerController(CustomerService customerService,ReservationService reservationService) {
		super();
		this.customerService = customerService;
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public Iterable<Customer> getAllCustomers(){
		
		return customerService.findAllCustomers();
		
	}
	
	@GetMapping("/{customerID}")
	public Customer getCustomerByID(@PathVariable("customerID") int customerID) {
		
		return customerService.findCustomerByID(customerID);
		
	}
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		customer = customerService.saveCustomer(customer);
//		for(Reservation rv : customer.getReservation()) {
//			
//			rv.setCustomer(customer);
//			reservationService.saveReservation(rv);
//			
//		}
		
		return customer;
		
	}
	
	@PutMapping("/{customerID}")
	public Customer updateCustomer(@PathVariable("customerID") int customerID, @RequestBody Customer customer) {
		
		customer.setCustomerID(customerID);
		return customerService.saveCustomer(customer);
		
	}
	
	@PutMapping
	public Iterable<Customer> updateCustomer2(@RequestBody Iterable<Customer> customer) {

		return customerService.updateCustomer(customer);
		
	}
	
	@DeleteMapping
	public void deleteCustomer(@RequestParam("customerID") List<Integer> customerID) {
		
		for(Integer id : customerID) {
			
			customerService.deleteCustomer2(customerService.findCustomerByID(id));
			
		}
		
	}
	
	@DeleteMapping("/{customerID}")
	public void deleteCustomer2(@PathVariable("customerID") Integer customerID) {
		
		customerService.deleteCustomer2(customerService.findCustomerByID(customerID));
		
	}

}
