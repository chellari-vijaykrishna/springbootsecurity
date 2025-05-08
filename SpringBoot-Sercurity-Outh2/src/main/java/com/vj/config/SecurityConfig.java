package com.vj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login","employment.html", 
				"health.html", "pmo.html", "aadhaar.html", "tax-records.html", "passport.html", 
				"rural-services.html", "covid-updates.html", "news.html").permitAll()
				.requestMatchers("/home","/user").authenticated()
				);
		http.csrf(csrf->csrf.disable());
		http.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error"));
		http.oauth2Login(oa -> oa.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error"));
		http.logout(log->log.logoutUrl("/logout").logoutSuccessUrl("/home"));

		return http.build();
	}
}
