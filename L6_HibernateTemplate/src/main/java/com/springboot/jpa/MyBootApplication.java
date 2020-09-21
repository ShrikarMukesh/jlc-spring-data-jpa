package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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

		log.info("My Boot Application...Starts");
		log.info("------------------------------------");
		
		Customer customer = new Customer("Hibernate","h@g.com",8584,"Guna");
		customerDAO.addCustomer(customer);
		
		List<Customer> listOfCustomer = customerDAO.getAllCustomers();
		listOfCustomer.forEach(cust-> System.out.println(cust));
		
		log.info("------------------------------------");
		log.info("My Boot Application...Ends");
	
	}
}