package com.springboot.jpa;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaCustomerDAO implements CustomerDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addCustomer(Customer cust) {
		entityManager.persist(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		//return entityManager.createNativeQuery(sqlString, resultClass)
		String jpql = "select * from mycustomers";
		return entityManager.createQuery(jpql, Customer.class).getResultList();
		
	}

	@Override
	public Customer getCustomer(int cid) {
		Customer customer = entityManager.find(Customer.class, cid);
		return customer;
	}

}
