package com.springboot.jpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springboot.jpa")
public class SpringBootJpaApp implements CommandLineRunner{

	Logger log =LoggerFactory.getLogger(SpringBootJpaApp.class);

	@Autowired
	CustomerDAO customerDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("My Boot Application...Starts - Lab7");
		log.debug("My Boot Application...Starts - Lab7");
		log.info("------------------------------------");
		
		Customer newCustomer = new Customer("Kamal", "kamal@jlc", 4578421, "KLBG");
		customerDAO.addCustomer(newCustomer);

		System.out.println("List of customers");
		//List<Customer> listCustomers = customerDAO.getAllCustomers();
		//listCustomers.forEach(cust->System.out.println(cust));
		
		System.out.println("Get Customer");
		Customer customer = customerDAO.getCustomer(4);
		System.out.println(customer);
		log.info("------------------------------------");
		log.info("My Boot Application...Ends - Lab7");
		log.debug("My Boot Application...Ends - Lab7");
		
	}
}
