package com.vj.configsercuity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.vj.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationClass {

	@Autowired
    private  IUserService service;

	
	
  
    // Password encoder bean
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authentication provider bean
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(service);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Authentication manager bean
	/*
	 * @Bean public AuthenticationManager
	 * authenticationManager(AuthenticationConfiguration config) throws Exception {
	 * return config.getAuthenticationManager(); }
	 */

    // Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       
        
        
        /*.logout(logout -> logout
                .logoutUrl("/logout")                      // Custom logout URL
                .logoutSuccessUrl("/login?logout")         // Redirect after logout
                .invalidateHttpSession(true)               // Invalidate session
                .clearAuthentication(true)                 // Clear auth info
                .deleteCookies("JSESSIONID")               // Delete session cookie
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/user/register").permitAll()
                .requestMatchers("/offers").authenticated()
                .requestMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
                .requestMatchers("/loanApprove").hasAuthority("MANAGER")
                .anyRequest().authenticated()
            ).httpBasic();*/

 

    http.logout(logout->logout
    		.logoutUrl("/logout")
    		.logoutSuccessUrl("/login?logout")
    		.invalidateHttpSession(true)
    		.deleteCookies("JSESSIONID")

    		
    		)
			/*
			 * .csrf(crsf->crsf .disable())
			 */
    
    
    
    
    
    .authorizeHttpRequests(auth->auth
    		.requestMatchers("/","/logout","/user/register").permitAll()
    		.requestMatchers("/offers").authenticated()
            .requestMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
            .requestMatchers("/loanApprove").hasAuthority("MANAGER")
            .anyRequest().authenticated()
 
    		)
    .formLogin(form->form
    		.loginPage("/user/login")
    		.permitAll()
    		 .defaultSuccessUrl("/",true)
		        .loginProcessingUrl("/login")
		        .failureUrl("/user/showLogin?error")
        );
    
    http.authenticationProvider(authenticationProvider());
                
    return http.build();
        
        
    }
}
