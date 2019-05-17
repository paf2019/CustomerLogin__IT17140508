package com.example.demoAdmin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAdmin.*;
import com.example.demo.CustomerDetails;

@RestController
@RequestMapping("/users")
public class AdminController{
	
	@Autowired
	AdminDAO adminDAO;
	
	/* SAVE AN EMPLOYEE */
	 @PostMapping("/admin")
	 public Admin createAdmin(@Valid @RequestBody Admin admin) {
	 return adminDAO.save(admin);
	 } 
	 
	 /* GET ALL EMPLOYEES*/
	 @GetMapping("/admin")
	 public List<Admin> getAlladmin(){
	 return adminDAO.findAll();
	 }

	 /* GET EMPLOYEE BY ID */
	 @GetMapping("/admin/{id}")
	 public ResponseEntity<Admin> getAdminId(@PathVariable(value="id") Integer
	id){


	 Admin admin=adminDAO.findOne(id);
	 
	 if(admin==null) {
	 return ResponseEntity.notFound().build();
	 }
	 return ResponseEntity.ok().body(admin);
	 }
	 
	 
	 
	 
	 
	 /* UPDATE AN EMPLOYEE BY ID */
	@PutMapping("/admin/{id}")
	 public ResponseEntity<Admin> updateAdmin(@PathVariable(value="id") Integer id,
	@Valid @RequestBody Admin admin){


	 Admin adm=adminDAO.findOne(id);
	 if(adm==null) {
	 return ResponseEntity.notFound().build();
	 }
	/* adm.setName(admin.getName());
	 adm.setUsername(admin.getUsername());
	 adm.setaddress(admin.getaddress());

	 */


	 Admin admi=adminDAO.save(adm);
	 return ResponseEntity.ok().body(admi);
	 } 


	
	 /*DELETE AN EMPLOYEE*/
	
	 @DeleteMapping("/admin/{id}")
	 public ResponseEntity<Admin> deleteadmin(@PathVariable(value="id") Integer id){

	 Admin adm=adminDAO.findOne(id);
	 if(adm==null) {
	 return ResponseEntity.notFound().build();
	 }
	
	 adminDAO.delete(adm);
	 return ResponseEntity.ok().build();
	 }

}
