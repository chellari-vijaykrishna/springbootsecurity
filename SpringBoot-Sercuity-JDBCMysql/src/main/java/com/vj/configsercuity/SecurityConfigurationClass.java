package com.vj.configsercuity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationClass {
   
	@Autowired
	private DataSource ds;
	

	// 1. JDBC-based UserDetailsService

	@Bean public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(ds); 
		// Custom query to retrieve userdetails 
		manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
	       // Custom query to retrieve authorities (roles) 
	       manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?"
	  );
	  
	  return manager;
	  
	  }

	// 2. Define security filter chain (Authorization rules)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->

		auth.requestMatchers("/").permitAll()
		.requestMatchers("/offers").authenticated().requestMatchers("/balance")
				.hasAnyAuthority("ROLE_CUSTOMER", "ROLE_MANAGER").requestMatchers("/loanApprove").hasAuthority("ROLE_MANAGER").anyRequest()
				.authenticated()).httpBasic();
		return http.build();
	}
}