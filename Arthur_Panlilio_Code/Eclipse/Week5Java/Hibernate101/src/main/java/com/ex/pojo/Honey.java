package com.ex.pojo;

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
	@Column(name="HP_ID")
	@SequenceGenerator(name="HP_ID_SEQ", sequenceName="HP_ID_SEQ", allocationSize=5, initialValue=100)
	@GeneratedValue(generator="HP_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	private double amount;
	private String honey;
	public Honey(int id, double amount, String honey) {
		super();
		this.id = id;
		this.amount = amount;
		this.honey = honey;
	}
	public Honey() {
		// TODO Auto-generated constructor stub
	}
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
