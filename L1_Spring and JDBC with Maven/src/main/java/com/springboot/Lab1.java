package com.springboot;

import java.util.List;
import org.springframework.context.annotation.*;

public class Lab1 {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(JLCConfig.class);
		CustomerDAO cdao= (CustomerDAO) ctx.getBean("custDAO");
		// 1. addCustomer
		//Customer cust1 = new Customer(1125, "Kiran", "Kiran@gmail.com", 98454, "Kalburgi");
		//cdao.addCustomer(cust1);
		// 2. getAllCustomers
		System.out.println("getAllCustomers");
		List<Customer> list=cdao.getAllCustomers();
		list.forEach(cust -> System.out.println(cust));
		ctx.close();
	}
}