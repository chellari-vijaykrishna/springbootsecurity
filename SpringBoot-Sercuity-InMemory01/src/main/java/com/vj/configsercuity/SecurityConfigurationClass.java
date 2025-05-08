package com.vj.configsercuity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationClass {

	// 1. Define users and roles (Authentication)
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(User.withUsername("raja")
				.password("$2a$10$UZ0kAgLY18CIaiYfRAnTKOgInhO72qzafeHi6g3jAJIAcfPrueCjW")
				.roles("CUSTOMER")
				.build());

		manager.createUser(User.withUsername("ramesh")
				.password("$2a$10$2OPTnC8OeZ0WWL46a3lJb.frpMIGC21Jga.C6bojyBG72tfxktqoi")
				.roles("MANAGER")
				.build());

		return manager;
	}

	
	// 2. Define security filter chain (Authorization rules)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> 
		
		auth.requestMatchers("/").permitAll()
		        .requestMatchers("/offers").authenticated()
		        .requestMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
				.requestMatchers("/loanApprove").hasRole("MANAGER")
				.anyRequest().authenticated())
		        .httpBasic();
		return http.build();
	}
}