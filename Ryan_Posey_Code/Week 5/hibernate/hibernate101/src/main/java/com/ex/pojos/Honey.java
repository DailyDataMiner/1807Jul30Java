package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEY")
public class Honey {
	
	@Id
	@Column(name="HP_ID")
	@SequenceGenerator(name="HP_ID_SEQ", sequenceName="HP_ID_SEQ")
	@GeneratedValue(generator="HP_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private double amount;
	
	@Column
	private String flavor;
	
	public Honey() {}

	public Honey(int id, double amount, String flavor) {
		super();
		this.id = id;
		this.amount = amount;
		this.flavor = flavor;
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

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public String toString() {
		return "Honey [id=" + id + ", amount=" + amount + ", flavor=" + flavor + "]";
	}
	
}
