package com.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerRepository;
import com.test.model.Customer;

@Service
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return repository.findById(customerId);
	}

	@Override
	public Customer addNewSCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	

}
