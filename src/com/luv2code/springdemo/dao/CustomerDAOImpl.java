package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute the query and get the result
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

}
