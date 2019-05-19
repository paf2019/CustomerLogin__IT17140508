package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
		user.setActive(1);
		Role userRole=roleRepo.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepo.save(user);
		
		
		}


	@Override
	public void saveUser() {
		// TODO Auto-generated method stub
		
	}

}
