package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Customer findCustomerByID(int ID) {

		return customerRepository.findById(ID).get();

	}

	@Transactional
	public Iterable<Customer> findAllCustomers() {

		return customerRepository.findAll();

	}

	@Transactional
	public Customer saveCustomer(Customer customer) {

		return customerRepository.save(customer);

	}
	
	@Transactional
	public Iterable<Customer> updateCustomer(Iterable<Customer> customer) {

		return customerRepository.saveAll(customer);

	}

	@Transactional
	public void deleteCustomer(List<Integer> customerID) {

		for (Integer id : customerID) {
			customerRepository.deleteById(id);
		}

	}

	@Transactional
	public void deleteCustomer2(Customer customer) {

		customerRepository.delete(customer);

	}

}
