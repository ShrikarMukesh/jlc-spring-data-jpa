package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
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
		log.debug("My Boot Application...Starts");
		log.info("------------------------------------");
		//Customer customer = new Customer("Merge","gmail",444,"KLBG");
		//customerDAO.addCustomer(customer);
			
		
		Customer customer1 = new Customer(14,"Mikar","yahoo",9845,"KLBG");
		Customer result = customerDAO.updateCustomer(customer1);
		System.out.println("The updated customer= "+result);
		
		Customer getCustomer = customerDAO.getCustomerByCid(14);
		log.info(getCustomer.toString());
		
		List<Customer> list=customerDAO.getAllCustomers();
		list.forEach(cust -> System.out.println(cust));
		
		//6.getCustomersByCity
		System.out.println("getCustomersByCity");
		list=customerDAO.getCustomersByCity("KLBG");
		list.forEach(cust -> System.out.println(cust));
		
		System.out.println("getCustomersByEmial");
		list=customerDAO.getCustomersByEmail("cmail");
		list.forEach(cust -> System.out.println(cust));
		
		System.out.println("getCustomersByEmailAndPhone");
		list = customerDAO.getCustomersByEmailAndPhone("cmail", 9845);
		list.forEach(cust->System.out.println(cust));
		
		System.out.println("getCustomerCount");
		BigInteger b = customerDAO.getCustomerCount();
		System.out.println("Total no of customers = "+b);
		
		log.info("------------------------------------");
		log.info("My Boot Application...Ends");
		log.debug("My Boot Application...Ends");
	}
}