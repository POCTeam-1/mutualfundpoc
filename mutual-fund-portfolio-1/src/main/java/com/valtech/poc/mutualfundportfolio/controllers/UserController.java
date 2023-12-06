package com.valtech.poc.mutualfundportfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.models.UserModel;
import com.valtech.poc.mutualfundportfolio.services.EmailService;
import com.valtech.poc.mutualfundportfolio.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	public void clearCacheForHandler(Object handler) {
		handlerMapping.registerMapping(null, handler, null);
	}

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user")
	public String userPage() {

		return "homePage";
	}

	@GetMapping("/admin")
	public String adminPage() {

		return "adminPage";
	}

	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute UserModel userModel, Model model) {
		userService.createUser(userModel.getUser());
		model.addAttribute("message", "Proceed to login");
		return "login";
	}

}
