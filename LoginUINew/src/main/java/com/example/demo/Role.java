package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin") 
	public class Role {
	
		@Id
		//@GeneratedValue(strategy=GenerationType.AUTO) 
		private int id;
		private String name;
		private String pnum;
		private String username;
		private String email;
		private String pwd;
		private String confirmpwd;
		private String role;
		private Set<Role> roles;
		
		public String getrole() {
			return role;
		}
		public void setrole(String role) {
			this.role=role;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		}
		
		
		
