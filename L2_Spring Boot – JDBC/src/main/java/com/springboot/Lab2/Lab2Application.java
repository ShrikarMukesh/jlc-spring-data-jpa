package com.springboot.Lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication(scanBasePackages="com.springboot.Lab2")
public class Lab2Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Lab2Application.class);

	@Autowired
	CustomerDAO customerDAO;

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}


	@Override
	public void run(String... args) {

		log.info("My Boot Application...Starts");
		log.debug("My Boot Application...Starts");
		log.info("------------------------------------");
		// 1. addCustomer
		//Customer cust1 = new Customer(474, "sd", "sd@jlc", 9999, "Blore");
		//customerDAO.addCustomer(cust1);
		// 2. getAllCustomers
		System.out.println("getAllCustomers");
		List<Customer> list=customerDAO.getAllCustomers();
		list.forEach(cust -> System.out.println(cust) );

		System.out.println("get customer");
		Customer customer = customerDAO.getCustomer(94);
		System.out.println(customer);

		System.out.println("Delete a customer");
		//boolean result = customerDAO.deleteCustomer(474);
		//System.out.println(result);
		
		log.info("------------------------------------");
		log.info("My Boot Application...Ends");
		log.debug("My Boot Application...Ends");
	}
}