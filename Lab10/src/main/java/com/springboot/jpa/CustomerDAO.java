package com.springboot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findCustomerByCname(String name);
	public List<Customer> findCustomerByEmail(String email);
	public List<Customer> findByPhone(long phone);
	public List<Customer> getCustomerByEmailAndPhone(String email,long phone);
	public List<Customer> getCustomerByEmailOrPhone(String email,long phone);
}