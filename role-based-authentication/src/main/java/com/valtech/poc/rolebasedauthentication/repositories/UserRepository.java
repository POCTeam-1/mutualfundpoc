package com.valtech.poc.rolebasedauthentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.poc.rolebasedauthentication.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByportfolioNumber(String portfolioNumber);

}
