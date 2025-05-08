package com.vj.encoder;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PassEncoder {
	
	public String passwordEncoder(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	     String encodedString = bCryptPasswordEncoder.encode(password);
	     return encodedString;
	}
    
}
