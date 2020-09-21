package com.springboot.jpa;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class HibernateCustomerDAO implements CustomerDAO{
	
	@Autowired
	HibernateTemplate hibernateTemp;
	public void addCustomer(Customer cust) {
		hibernateTemp.save(cust);
	}
	public List<Customer> getAllCustomers() {
		return hibernateTemp.loadAll(Customer.class);
	}
}
