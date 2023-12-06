package com.valtech.poc.mutualfundportfolio.models;

import com.valtech.poc.mutualfundportfolio.entities.User;

public class UserModel {

	private int id;
	private String name;
	private int age;
	private String email;
	private String password;

	public UserModel() {
		super();
	}

	public UserModel(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.age = user.getAge();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public User getUser() {
		return new User(id, name, age, email, password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
