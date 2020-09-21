package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	@Autowired
	UsersDAO usersDAO;

	@Autowired
	UserService us;
	
	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("My Boot Application...Starts---Lab9");
		log.info("-------------------------------------------------");

		UserEntity user = new UserEntity(2,"Shrikar");
		usersDAO.save(user);
  
		
		UserEntity u = us.getUserByIdWithNamedQuery1(2);
		System.out.println(u);
		
		
		/*
		 * Customer addingCustomer = new Customer("Kim jong","kim.com",984548,"KIM");
		 * customerDAO.save(addingCustomer);
		 * 
		 * Customer myCustomer = new Customer("ddd", "ddd@jlc", 12345, "Hyd");
		 * customerDAO.saveAndFlush(myCustomer);
		 * 
		 * List<Customer> listOfCustomers = CustomerUtility.getAllCustomers();
		 * customerDAO.saveAll(listOfCustomers);
		 * 
		 * 
		 * List<Customer> listCustomers = customerDAO.findAll();
		 * listCustomers.forEach(cust -> System.out.println(cust));
		 * 
		 * System.out.println("findAll(Sort)"); listCustomers =
		 * customerDAO.findAll(Sort.by(Order.asc("cname")));
		 * listCustomers.forEach(cust->System.out.println(cust));
		 * 
		 * 
		 * Customer cust4=customerDAO.getOne(26); System.out.println(cust4);
		 * 
		 * //Optional<Customer> customerById = customerDAO.findById(20); Customer
		 * customerById = customerDAO.findById(20).get();
		 * System.out.println(customerById);
		 * 
		 * System.out.println("Customer with this id exists = "+customerDAO.existsById(
		 * 21));
		 * 
		 * long numberOfCustomers = customerDAO.count();
		 * System.out.println("Total No of customers = " + numberOfCustomers);
		 * 
		 * 
		 * 
		 * System.out.println("void deleteById(ID id)"); customerDAO.deleteById(11);
		 * 
		 * System.out.println("void delete(T entity)"); Customer customerTodelete =
		 * customerDAO.findById(22).get(); customerDAO.delete(customerTodelete);
		 * 
		 * 
		 * customerDAO.flush();
		 */

		log.info("My Boot Application...Ends");
	}
}