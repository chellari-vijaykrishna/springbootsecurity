package com.vj.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vj.encoder.PassEncoder;
import com.vj.model.Users;
import com.vj.repo.IUserRepo;

@Service
public class IUserServiceImpl implements IUserService {
    
	
	@Autowired
	private PassEncoder encoder;
	
	@Autowired
	private IUserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userEntity = repo.findByUserName(username);
		User user=null;
		if(userEntity==null) {
			throw new UsernameNotFoundException("User Not Found or Not Registered");
		}
		else {
			user =new User(username, userEntity.getPassword(), 
					
					userEntity.getRole().stream()
					.map(use-> new SimpleGrantedAuthority(use)).collect(Collectors.toSet()));
		}
		
		return user;
	}

	@Override
	public String registerUser(Users user) {
		
		Users userEntity = repo.findByUserName(user.getUserName());
		String res=null;
		
		if(userEntity==null) {
			user.setPassword(encoder.passwordEncoder(user.getPassword()));
			res = repo.save(user).getUnid()+" : Registered";
		}
		else
		   res=  "UserAlready registered with :"+ userEntity.getUnid();
		return res;
	}

}
