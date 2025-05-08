package com.vj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.model.Users;

public interface IUserRepo extends JpaRepository<Users, Integer> {
	
     public Users findByUserName(String userName);
}
