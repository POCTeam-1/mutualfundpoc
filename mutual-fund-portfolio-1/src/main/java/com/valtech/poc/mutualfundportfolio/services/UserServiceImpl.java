package com.valtech.poc.mutualfundportfolio.services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;

	LocalDate date = LocalDate.now();

	@PostConstruct
	public void populateAdmin() {
		User userAdmin = new User("Admin", 22, "admin123@gmail.com", "admin@123", "admin");
		userAdmin.setEnabled(true);
		userAdmin.setRole("ADMIN");
		userAdmin.setRegisteredDate(date);

	}

	@Override
	public User createUser(User user) {
		String toMail = user.getEmail();
		String portfolioNumber = generatePortfolioNumber(user.getName());
		String subject = "This is mutualfund-portfolio UserId";
		String body = "Hi " + user.getName() + ",\nYour mutualfund portfolio ID = " + portfolioNumber + ".";
		emailService.sendSimpleMessage(toMail, subject, body);

		user.setPortfolioNumber(portfolioNumber);
		user.setEnabled(true);
		user.setRole("USER");
		user.setRegisteredDate(date);

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userRepository.findByportfolioNumber(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return user;
	}

}
