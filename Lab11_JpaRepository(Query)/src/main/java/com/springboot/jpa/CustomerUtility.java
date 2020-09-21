package com.springboot.jpa;

import java.util.*;


public class CustomerUtility {

	public static List<Customer> getAllCustomers(){
		List<Customer> listOFCustomers = Arrays.asList(
				new Customer("Kapi","Kapi.com",5454,"Bidar"),
				new Customer("Kishor","Ki.com",7777,"Kalyan"),
				new Customer("Viki","V.com",7845,"Bang")
				);

		return listOFCustomers;
	}
}
