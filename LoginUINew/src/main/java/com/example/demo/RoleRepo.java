package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepo")
public interface RoleRepo extends JpaRepository<User,Long>{
	Role findByRole(String role);
}
