package com.restexception.restexception.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restexception.restexception.model.Customer;
import com.restexception.restexception.repository.MockCustomerRepository;
import com.restexception.restexception.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private MockCustomerRepository customerRepostiory;
	
	@Override
	public Customer findById(Integer id) {
		Customer customer = customerRepostiory.getById(id);
		return customer;
	}
	
	public Customer verifyIfExistsCustomer(Integer id) {
		Customer entity = customerRepostiory.getById(id);
		return null;
	}

}
