package com.vj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankControllerClass {
	
	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	
	@GetMapping("/balance")
	public String showBalance() {
		return "balance";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/loanApprove")
	public String showOLoanApprove() {
		return "loan";
		
	}
	
	/*
	 * @GetMapping("/error") public String showErrorPage() { return "error"; }
	 */
	
}
