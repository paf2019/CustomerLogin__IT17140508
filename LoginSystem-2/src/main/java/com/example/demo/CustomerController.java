package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company") 
public class CustomerController {
	
	@Autowired
	 CustomerDAO customerDAO; 
	
	/* SAVE AN EMPLOYEE */
	 @PostMapping("/customers")
	 public CustomerDetails createEmployee(@Valid @RequestBody CustomerDetails customer) {
	 return customerDAO.save(customer);
	 } 
	 
	 /* GET ALL EMPLOYEES*/
	 @GetMapping("/customers")
	 public List<CustomerDetails> getAllEmployees(){
	 return customerDAO.findAll();
	 }

	 /* GET EMPLOYEE BY ID */
	 @GetMapping("/customers/{id}")
	 public ResponseEntity<CustomerDetails> getEmployeeById(@PathVariable(value="id") Integer
	id){


	 CustomerDetails customer=customerDAO.findOne(id);
	 
	 if(customer==null) {
	 return ResponseEntity.notFound().build();
	 }
	 return ResponseEntity.ok().body(customer);
	 }
	 
	 
	 
	 
	 
	 /* UPDATE AN EMPLOYEE BY ID */
	@PutMapping("/customers/{id}")
	 public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable(value="id") Integer id,
	@Valid @RequestBody CustomerDetails cusDetails){


	 CustomerDetails cus=customerDAO.findOne(id);
	 if(cus==null) {
	 return ResponseEntity.notFound().build();
	 }
	 cus.setName(cusDetails.getName());
	 cus.setUsername(cusDetails.getUsername());
	 cus.setaddress(cusDetails.getaddress());
	 cus.setPhoneNum(cusDetails.getPhoneNum());
	 cus.setaddress(cusDetails.getaddress());
	 cus.setConfirmpwd(cusDetails.getConfirmpwd());
	 cus.setPwd(cusDetails.getPwd());
	 cus.setEmail(cusDetails.getEmail());

	
	 CustomerDetails cusdet=customerDAO.save(cus);
	 return ResponseEntity.ok().body(cusdet);
	 } 


	
	 /*DELETE AN EMPLOYEE*/
	
	 @DeleteMapping("/customers/{id}")
	 public ResponseEntity<CustomerDetails> deletecustomer(@PathVariable(value="id") Integer id){

	 CustomerDetails cus=customerDAO.findOne(id);
	 if(cus==null) {
	 return ResponseEntity.notFound().build();
	 }
	
	 customerDAO.delete(cus);
	 return ResponseEntity.ok().build();
	 }
	 
	 
	} 
	 
	 


