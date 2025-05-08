package com.vj.ms;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OauthRestController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/login")
	public String showlogin() {
		return "login";
	}

	@GetMapping("/home")
	public String showlogi() {
		return "loginhtml";
	}
	/*
	 * @GetMapping("/user") public Map<String, Object>
	 * getUser(@AuthenticationPrincipal OAuth2User principal) {
	 * System.out.println("OAuth User Attributes: " + principal.getAttributes()); //
	 * Prints to console 
	 * Map<String, Object> map = principal.getAttributes();
	 * System.out.println(map.containsKey("name"));
	 * System.out.println(map.containsKey("email"));
	 * System.out.println(map.get("name")); System.out.println(map.get("email"));
	 * return principal.getAttributes(); }
	 */
	
	@GetMapping("/user")
	public String getUser(@AuthenticationPrincipal OAuth2User principal,Map<String, Object> map) {
	    System.out.println("OAuth User Attributes: " + principal.getAttributes()); // Prints to console	    
	    Map<String, Object> mapp = principal.getAttributes();      
	    map.put("name", mapp.get("name"));
	    map.put("email", mapp.get("email"));
	    return "user";
	}


}
