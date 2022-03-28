package com.restexception.restexception.repository;

import com.restexception.restexception.model.Customer;

public interface MockCustomerRepository {
	
	Customer getById(Integer id);

}
