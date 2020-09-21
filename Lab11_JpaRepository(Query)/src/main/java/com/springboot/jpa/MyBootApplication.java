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

		log.info("My Boot Application...Starts---Lab11");
		log.info("-------------------------------------------------");
		List<Customer> listCustomers = customerDAO.getCustomers("Dinesh");
		listCustomers.forEach(cust->System.out.println(cust));
		
		System.out.println("--------CustomersNameAndEmail----------");
		listCustomers = customerDAO.getCustomers("Dinesh", "DADD@jlc");
		listCustomers.forEach(cust->System.out.println(cust));
		
		
		log.info("--------------------------------------------------");
		log.info("My Boot Application...Ends---Lab101");
	}
}