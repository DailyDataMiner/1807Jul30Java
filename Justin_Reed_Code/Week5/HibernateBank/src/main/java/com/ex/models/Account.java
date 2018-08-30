package com.ex.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Account {
	
	@Id @SequenceGenerator(name="EXA_ID", sequenceName="EXA_ID")
	@GeneratedValue(generator="EXC_ID", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private User owner;
	
	@NotNull
	@Size(min=3, max=32)
	private String name;
	
	@Column(nullable =false)
	@Min(0)
	private double balance;
	
	public Account() {
		super();
	}
	
	public Account(int id, User owner, String name, double balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", name=" + name + ", balance=" + balance + "]";
	}
	

}
