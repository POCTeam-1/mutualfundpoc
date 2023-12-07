package com.valtech.poc.rolebasedauthentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.poc.rolebasedauthentication.models.UserModel;
import com.valtech.poc.rolebasedauthentication.services.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute("userModel") UserModel userModel, Model model) {
		userService.createUser(userModel);
		model.addAttribute("message", "Proceed to login");
		return "login";
	}

	@GetMapping("/register")
	public String registerForm() {
		
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	@GetMapping("/")
	public String landingPage() {
		
		return "landingPage";
	}

	@GetMapping("/user")
	public String userPage() {

		return "homepage";
	}

	@GetMapping("/admin")
	public String adminPage() {

		return "adminPage";
	}

}
