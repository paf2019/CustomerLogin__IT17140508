package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo2 extends JpaRepository<CustomerDetails, Integer>{
	
}
