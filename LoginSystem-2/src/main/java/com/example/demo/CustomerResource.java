package com.example.demo;

import java.util.ArrayList;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {

	CustomerRepo repo=new CustomerRepo();
	@GetMapping
	@RequestMapping("Customers1")
	public List<CustomerDetails> getcustomers()
	{
		//List<CustomerDetails> customers=new ArrayList<>();
		
		
List<CustomerDetails> customers=new ArrayList<>();
		
		customers=new ArrayList<>();
		CustomerDetails a1=new CustomerDetails();
		a1.setName("Pam");
		//a1.setPoints(50);
		a1.setId(10);
		
		CustomerDetails a2=new CustomerDetails();
		a2.setName("Pamal");
		//a2.setPoints(500);
		a2.setId(100);
		
		CustomerDetails a3=new CustomerDetails();
		a3.setName("Kasun");
		//a1.setPoints(50);
		a3.setId(10);
		
		customers.add(a1);
		customers.add(a2);
		customers.add(a3);
		
		
		return repo.getCustomers();
	
		//return customers;
	
}
	
	//@POST()
	
	@RequestMapping("customer")
	public CustomerDetails createCustomer(CustomerDetails c1)
	{
		System.out.println();
		
		repo.create(c1);
		repo.getCustomers();
		return c1;
	}
	
	
	/*
	@GetMapping
	@RequestMapping("customer/{id}")
	//@Produces(MediaType.APPLICATION_XML)
	public CustomerDetails createCustomer(@PathParam("id") Integer id)
	{
		return repo.getCustomer(id);
	}
	*/
}
