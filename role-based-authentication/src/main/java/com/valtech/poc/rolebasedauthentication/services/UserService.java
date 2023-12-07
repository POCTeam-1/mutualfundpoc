package com.valtech.poc.rolebasedauthentication.services;

import com.valtech.poc.rolebasedauthentication.entities.User;
import com.valtech.poc.rolebasedauthentication.models.UserModel;

public interface UserService {

	User createUser(UserModel userModel);

	String generatePortfolioNumber(String name);

}