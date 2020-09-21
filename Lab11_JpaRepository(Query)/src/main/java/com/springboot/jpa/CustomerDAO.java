package com.springboot.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	@Query("from Customer cust where cust.cname=?1")
	List<Customer> getCustomers(String cname);

	@Query("from Customer cust where cust.cname = ?1 AND cust.email = ?2")
	List<Customer> getCustomers(String cname, String email);

	@Query("from Customer cust where cust.city = ?1 order by cname ASC")
	List<Customer> getCustomersByCity(String city);

	@Query("from Customer cust where cust.city = ?1")
	List<Customer> findCustomersByCity(String city,Sort sort);

	@Query("from Customer cust where cust.city = ?1")
	List<Customer> readCustomersByCity(String city, Pageable pageable);

	@Query(value = "select * from customers where phone = :myphone", nativeQuery = true)
	List<Customer> findCustomersByPhone(@Param("myphone") long phone);
}