package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVES")
public class Cave {

	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(name="C_SEQ_GEN", sequenceName="CAVE_SEQ", allocationSize=100) // allocationSize; optional
	@GeneratedValue(generator="C_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
//	@Column(name="SQFT")
	@Column(name="")
	private double squareFootage;
	
	@Column
	private double rent;

	public Cave() {}
	
	public Cave(int id, double squareFootage, double rent) {
		super();
		this.id = id;
		this.squareFootage = squareFootage;
		this.rent = rent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", squareFootage=" + squareFootage + ", rent=" + rent + "]";
	}
	
}
