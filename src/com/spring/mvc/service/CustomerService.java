package com.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.entity.Customer;

@Service
public interface CustomerService {

	
		public List<Customer> getCustomers();
		
		public void saveCustomer(Customer customer);
		
		public Customer getCustomer(int id);
		
		public void deleteCustomer(int id);
	
}
