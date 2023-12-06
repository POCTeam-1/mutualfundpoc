package com.valtech.poc.mutualfundportfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.models.UserRegisterModel;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(UserRegisterModel userRegisterModel) {
		User user=new User();
		return userRepository.save(user);
	}
	
	

}
