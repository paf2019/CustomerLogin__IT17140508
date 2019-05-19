package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement

@Entity
@Table(name="admin") 
	public class User {
	
		@Id
		//@GeneratedValue(strategy=GenerationType.AUTO) 
		private int id;
		private String name;
		private String pnum;
		private String username;
		private String email;
		private String pwd;
		private String confirmpwd;
		private String address;
		private int active;
		private String role;
		private Set<Role> roles;
		
		public String getrole() {
			return role;
		}
		public void setrole(String role) {
			this.role=role;
		}
		
		 
		
		public Set<Role> getRoles() {
			return roles;
		}
		
		@ManyToMany
	//	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		
		}
		
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public String getaddress() {
			return address;
		}
		public void setaddress(String address) {
			this.address=address;
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
		public String getPhoneNum() {
			return pnum;
		}
		public void setPhoneNum(String phoneNum) {
			this.pnum = phoneNum;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getConfirmpwd() {
			return confirmpwd;
		}
		public void setConfirmpwd(String confirmpwd) {
			this.confirmpwd = confirmpwd;
		}
		
		
		
		
	
}
