package com.valtech.poc.mutualfundportfolio.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "userId",referencedColumnName = "id")
	private User user;
	@ManyToOne(targetEntity = MutualFund.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "mutualfundId",referencedColumnName = "id")
	private MutualFund mutualFund;
	@ManyToOne(targetEntity = MutualFundScheme.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "schemeId",referencedColumnName = "id")
	private MutualFundScheme mutualFundScheme;
//	@ManyToOne(targetEntity = MutualFundScheme.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "schemeNav",referencedColumnName = "id")
//	private MutualFundScheme mutualFundScheme1;
	private Double amount;
	private Double navUnits;
	private LocalDate date;

	public Transaction() {
		super();
	}

	public Transaction(User user, MutualFund mutualFund, MutualFundScheme mutualFundScheme, Double amount,
			Double navUnits, LocalDate date) {
		super();
		this.user = user;
		this.mutualFund = mutualFund;
		this.mutualFundScheme = mutualFundScheme;
		this.amount = amount;
		this.navUnits = navUnits;
		this.date = date;
	}

	public Transaction(int id, User user, MutualFund mutualFund, MutualFundScheme mutualFundScheme, Double amount,
			Double navUnits, LocalDate date) {
		super();
		this.id = id;
		this.user = user;
		this.mutualFund = mutualFund;
		this.mutualFundScheme = mutualFundScheme;
		this.amount = amount;
		this.navUnits = navUnits;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MutualFund getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(MutualFund mutualFund) {
		this.mutualFund = mutualFund;
	}

	public MutualFundScheme getMutualFundScheme() {
		return mutualFundScheme;
	}

	public void setMutualFundScheme(MutualFundScheme mutualFundScheme) {
		this.mutualFundScheme = mutualFundScheme;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getNavUnits() {
		return navUnits;
	}

	public void setNavUnits(Double navUnits) {
		this.navUnits = navUnits;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
