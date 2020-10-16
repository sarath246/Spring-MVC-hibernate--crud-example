package com.spring.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.CustomerDao;
import com.spring.mvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
	
		System.out.println("\n");
		System.out.println("Staring service list...");
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		System.out.println("Staring service save...");
		
		customerDao.saveCustomer(customer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {

		System.out.println("Staring service get customer id...");
		
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {

		System.out.println("Staring service delete...");

		customerDao.deleteCustomer(id);
		
	}

}
