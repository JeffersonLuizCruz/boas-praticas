package com.restexception.restexception.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.restexception.restexception.model.Customer;
import com.restexception.restexception.repository.MockCustomerRepository;
import com.restexception.restexception.service.exception.NotFoundException;

@Repository
public class MockCustomerRepositoryImpl implements MockCustomerRepository{

	Map<Integer, Customer> mockDAO;
	
	private static String NOT_FOUND_EXCEPTION = "Customer [ %s ] com ID [ %s ] não encontrado no sistema.";
	
	public MockCustomerRepositoryImpl() {
		mockDAO = new HashMap<>();
		
		Customer customer = new Customer(1L, "Hugo", "Exemplo de entidade", "Entidade Fake");
		mockDAO.put(1, customer);
	}
	
	@Override
	public Customer getById(Integer id) {
		if(!mockDAO.containsKey(id)) {
			throw new NotFoundException(String.format(NOT_FOUND_EXCEPTION, mockDAO.get(id).getName(), id));
		}
		return mockDAO.get(id);
	}

}
