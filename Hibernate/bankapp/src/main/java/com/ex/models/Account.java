package com.ex.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="bank_accounts")
public class Account {

	
	@Id
	@Column(name="acc_id")
	@SequenceGenerator(name="acc_SEQ_GEN", sequenceName="acc_SQ")
	@GeneratedValue(generator="acc_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	private User owner;
	
	@NotNull
	@Size(min=3, max=32)
	private String name;
	
	@NotNull
	@Min(0)
	private Double balance;
	
	
	public Account() {}
	
	public Account(int id, User owner, String name, Double balance) {
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
