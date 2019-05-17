package com.example.demoAdmin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Admin {

	@Entity
	@Table(name="admin") 
		public class CustomerDetails {
		
			@Id
			//@GeneratedValue(strategy=GenerationType.AUTO) 
			private int id;
			private String name;
			private String username;	
			private String pwd;
			private String confirmpwd;
			
	
			
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
			
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
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

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
