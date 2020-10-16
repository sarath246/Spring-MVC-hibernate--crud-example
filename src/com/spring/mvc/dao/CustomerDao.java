package com.spring.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Customer;

@Repository
public interface CustomerDao {

	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);
	
}
