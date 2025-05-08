package com.vj.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vj.model.Users;

public interface IUserService extends UserDetailsService{
	public String registerUser(Users user);
}
