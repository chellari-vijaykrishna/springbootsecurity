package com.vj.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vj.model.Users;
import com.vj.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

	@Autowired
	private IUserService service;
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String userRegisterShow(@ModelAttribute("user") Users user) {
		return "register";
	}

	@PostMapping("/register")
	public String userRegistedDetails(@ModelAttribute("user") Users user, Map<String, String> map) {
		String res = service.registerUser(user);
		map.put("msg", res);
		return "register";
	}

}
