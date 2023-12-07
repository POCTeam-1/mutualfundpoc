package com.valtech.poc.rolebasedauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valtech.poc.rolebasedauthentication.entities.User;
import com.valtech.poc.rolebasedauthentication.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByportfolioNumber(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}

		return new CustomUserDetails(user);
	}

}
