package com.userFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@RequestMapping("/primaryAccount")
	public String primaryAccount() {
		
		return "primaryAccount";
	}
	
	
	@RequestMapping("/savingsAccount")
    public String savingsAccount() {
		
		return "savingsAccount";
	}
	
	
}
