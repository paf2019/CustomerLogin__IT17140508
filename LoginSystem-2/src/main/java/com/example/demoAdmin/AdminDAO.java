package com.example.demoAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.CustomerDetails;
import com.example.demo.CustomerRepo2;

@Service 
public class AdminDAO {

	
	@Autowired
	AdminRepo adminRepository; 
	
	/* SAVE AN EMPLOYEE */
	 @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	 public Admin save(Admin adm) {
	 return adminRepository.save(adm);
	 } 
	 
	 /* SEARCH ALL EMPLOYEES */
	 public List<Admin> findAll(){
	 return adminRepository.findAll();
	 }

	 /* GET AN EMPLOYEE */
	 public Admin findOne(int id) {
	 Optional<Admin> op = adminRepository.findById(id);
	 if(op.isPresent()) {
	 return op.get();
	 }
	 else {
	 return null;
	 }
	 }

	 /* DELETE AN EMPLOYEE by id */
	 @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	 public void delete(Admin admin) {
		 adminRepository.delete(admin);
	 } 
}
