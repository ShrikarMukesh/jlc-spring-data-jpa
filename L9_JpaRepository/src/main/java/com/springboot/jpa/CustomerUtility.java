package com.springboot.jpa;

import java.util.*;


public class CustomerUtility {
	public static void main(String[] args) {
		
		/*
		 * Map<String,String> map = new HashMap<>(); map.put(null, "null");
		 * System.out.println( map.put(null, "KKK")); System.out.println(map);
		 * 
		 * Set<String> set = new HashSet<String>(); set.add(null); set.add(null);
		 * System.out.println(set);
		 */
 
	}
	public static List<Customer> getAllCustomers(){
		List<Customer> listOFCustomers = Arrays.asList(
				new Customer("Kapi","Kapi.com",5454,"Bidar"),
				new Customer("Kishor","Ki.com",7777,"Kalyan"),
				new Customer("Viki","V.com",7845,"Bang")
				);

		return listOFCustomers;
	}
}
