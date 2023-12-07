package com.valtech.poc.rolebasedauthentication.services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.poc.rolebasedauthentication.entities.User;
import com.valtech.poc.rolebasedauthentication.models.UserModel;
import com.valtech.poc.rolebasedauthentication.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	LocalDate date = LocalDate.now();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void populateAdmin() {
		UserModel userAdmin = new UserModel("Admin", 22, "admin123@gmail.com", "admin@123");
		createUser(userAdmin);
	}

	@Override
	public User createUser(UserModel userModel) {
		User user = new User(userModel.getName(), userModel.getAge(), userModel.getEmail(), passwordEncoder.encode( userModel.getPassword()));
		user.setEnabled(true);
		user.setPortfolioNumber(generatePortfolioNumber(userModel.getName()));
		user.setRegisteredDate(date);
		user.setRole("USER");
//		user.setRole("ADMIN");
		return userRepository.save(user);
	}

	@Override
	public String generatePortfolioNumber(String name) {

		String initials = name.substring(0, 3);
		StringBuilder randomNumbers = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			randomNumbers.append(random.nextInt(10));
		}
		return initials + randomNumbers.toString();
	}

}
