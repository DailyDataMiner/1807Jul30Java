package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOTS")
public class Honey {

	@Id
	@Column(name="HONEYPOT_ID")
	@SequenceGenerator(name="HP_SEQ_GEN", sequenceName="HONEYPOT_SEQ") // allocationSize; optional
	@GeneratedValue(generator="HP_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private double amount;
	
	@Column
	private String honey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getHoney() {
		return honey;
	}

	public void setHoney(String honey) {
		this.honey = honey;
	}

	@Override
	public String toString() {
		return "Honey [id=" + id + ", amount=" + amount + ", honey=" + honey + "]";
	}
	
}
