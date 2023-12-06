package com.valtech.poc.mutualfundportfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@Autowired
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
