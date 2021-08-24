package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Customer;
import com.test.services.CustomerServices;



@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerServices service;
	
	@RequestMapping(value= "/customer/all", method= RequestMethod.GET)
	public List<Customer> getStudents() {
		return service.getCustomers();
	}

	@RequestMapping(value= "/customer/{id}", method= RequestMethod.GET)
	public Customer getCustomerById(@PathVariable int id) throws Exception {

		Optional<Customer> emp =  service.getCustomerById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Customer with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/customer/add", consumes="application/json", method= RequestMethod.PUT)
		public Customer createCustomer(@RequestBody Customer customer) throws Exception {
		
		Optional<Customer> cust =  service.getCustomerById(customer.getId());
		if(!cust.isPresent())
			return service.addNewSCustomer(customer);

		if(customer.getFirstName() == null || customer.getFirstName().isEmpty())
			customer.setFirstName((cust.get().getFirstName()));
		
		if(customer.getLastName() == null || customer.getLastName().isEmpty())
			customer.setLastName((cust.get().getLastName()));

		customer.setId(customer.getId());
		return service.updateCustomer(customer);
	}


}
