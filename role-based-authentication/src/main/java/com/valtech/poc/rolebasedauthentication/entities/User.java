package com.valtech.poc.rolebasedauthentication.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String email;
	private String password;
	private String portfolioNumber;
	private boolean enabled;
	private LocalDate registeredDate;
	private String role;

	public User() {
		super();
	}

	
	public User(String name, int age, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}


	public User(String name, int age, String email, String password, String portfolioNumber, boolean enabled,
			LocalDate registeredDate, String role) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.portfolioNumber = portfolioNumber;
		this.enabled = enabled;
		this.registeredDate = registeredDate;
		this.role = role;
	}

	public User(int id, String name, int age, String email, String password, String portfolioNumber, boolean enabled,
			LocalDate registeredDate, String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.portfolioNumber = portfolioNumber;
		this.enabled = enabled;
		this.registeredDate = registeredDate;
		this.role = role;
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

	public String getPortfolioNumber() {
		return portfolioNumber;
	}

	public void setPortfolioNumber(String portfolioNumber) {
		this.portfolioNumber = portfolioNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
