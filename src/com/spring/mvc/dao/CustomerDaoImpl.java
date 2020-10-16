package com.spring.mvc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		System.out.println("Creating criteriaBuilder..." + cb);
		
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		System.out.println("Creating criteriaQuery..." + cq);
		
		Root<Customer> root = cq.from(Customer.class);
		System.out.println("Creating root..." + root);
		cq.select(root);
		
		Query query = session.createQuery(cq);
		System.out.println("Final query..." + query);
		System.out.println("Success...");
		
		return query.getResultList();
		
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Saving customer details...");
		session.saveOrUpdate(customer);
		
		System.out.println("Success...");
	}

	@Override
	public Customer getCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Getting customer id...");
		Customer customer = session.get(Customer.class, id);
		
		System.out.println("Customer id :" + customer);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Deleting customer...");
		Customer book = session.byId(Customer.class).load(id);
		session.delete(book);
		
		System.out.println("Customer is :" + book);
		System.out.println("Success...");
	}

}
