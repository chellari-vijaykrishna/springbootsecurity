package com.vj.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PassEncoder {
	
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
    public static void main(String[] args) {
    	
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	String encodedPassword = encoder.encode("rani");
    	String encodedPassword1 = encoder.encode("hyd");
    	System.out.println(encodedPassword);
    	System.out.println(encodedPassword1);
	}
}
