package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public Customer findCustomerByID(int ID) {

		return customerRepository.findById(ID).get();

	}

	public Iterable<Customer> findAllCustomers() {

		return customerRepository.findAll();

	}

	public Customer saveCustomer(Customer customer) {

		return customerRepository.save(customer);

	}
	
	public Iterable<Customer> updateCustomer(Iterable<Customer> customer) {

		return customerRepository.saveAll(customer);

	}

	public void deleteCustomer(List<Integer> customerID) {

		for (Integer id : customerID) {
			customerRepository.deleteById(id);
		}

	}

	public void deleteCustomer2(Customer customer) {

		customerRepository.delete(customer);

	}

}
