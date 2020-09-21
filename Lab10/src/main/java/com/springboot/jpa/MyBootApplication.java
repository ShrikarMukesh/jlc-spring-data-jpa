package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Order;
//import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication(scanBasePackages="com.springboot.jpa")
public class MyBootApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MyBootApplication.class);

	@Autowired
	CustomerDAO customerDAO;

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("My Boot Application...Starts---Lab10");
		log.info("-------------------------------------------------");
		
		System.out.println("-----------findCustomerByCname---------");
		List<Customer> findCustomerByCname = customerDAO.findCustomerByCname("Dinesh");
		findCustomerByCname.forEach(cust->System.out.println(cust));
		
		System.out.println("---------findCustomerByCname------------");
		List<Customer> findCustomerByEmail = customerDAO.findCustomerByEmail("DADD@jlc");
		findCustomerByEmail.forEach(cust->System.out.println(cust));
		
		System.out.println("---------findByPhone------------");
		List<Customer> findByPhone = customerDAO.findByPhone(9845);
		findByPhone.forEach(cust->System.out.println(cust));

		System.out.println("---------getCustomerByEmailAndPhone------------");
		List<Customer> getCustomerByEmailAndPhone = customerDAO.getCustomerByEmailAndPhone("kim.com",984548);
		getCustomerByEmailAndPhone.forEach(cust->System.out.println(cust));

		System.out.println("---------getCustomerByEmailOrPhone------------");
		List<Customer> getCustomerByEmailOrPhone = customerDAO.getCustomerByEmailOrPhone("kim.com",45455);
		getCustomerByEmailOrPhone.forEach(cust->System.out.println(cust));
		
		log.info("--------------------------------------------------");
		log.info("My Boot Application...Ends---Lab10");
	}
}