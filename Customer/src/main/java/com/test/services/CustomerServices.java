package com.test.services;

import java.util.List;
import java.util.Optional;

import com.test.model.Customer;

public interface CustomerServices {

	public List<Customer> getCustomers();

	public Optional<Customer> getCustomerById(int customerIdId);

	public Customer addNewSCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);

	

}
