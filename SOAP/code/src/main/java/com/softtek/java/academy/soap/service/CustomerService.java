package com.softtek.java.academy.soap.service;

import org.springframework.stereotype.Service;

import com.softtek.java.academy.soap.domain.model.Customer;

@Service
public class CustomerService {

	public Customer findCustomerById(final String id) {
		final Customer customer = new Customer();
		customer.setId(id);
		customer.setCompanyName("Softtek");
		customer.setEmail("user@softtek.com");
		customer.setNotes("Java Academy 2015");
		customer.setPhone("+52 5526268282");
		
		return customer;
	}
}
