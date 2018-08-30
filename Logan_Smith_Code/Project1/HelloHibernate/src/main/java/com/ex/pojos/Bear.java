package com.ex.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEARS")
public class Bear {

	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name="B_SEQ_GEN", sequenceName="BEAR_SEQ")
	@GeneratedValue(generator="B_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int bearID;
	@Column
	private String color;
	@Column
	private double height;
	@Column(nullable=false)
	private String breed;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_CAVE")
	private Cave home;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinTable(name="HONEY_POT")
	private Honey potOfHoney;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB",
	joinColumns=@JoinColumn(name="PARENT_ID"),
	inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	
	private Set<Bear> bearCubs;
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(String color, double height, String breed, Cave home, Honey potOfHoney,
			Set<Bear> bearCubs) {
		super();
		this.color = color;
		this.height = height;
		this.breed = breed;
		this.home = home;
		this.potOfHoney = potOfHoney;
		this.bearCubs = bearCubs;
	}

	@Override
	public String toString() {
		return "Bear [bearID=" + bearID + ", color=" + color + ", height=" + height + ", breed=" + breed + ", home="
				+ home + ", potOfHoney=" + potOfHoney + ", bearCubs=" + bearCubs + "]";
	}

	public int getBearID() {
		return bearID;
	}

	public void setBearID(int bearID) {
		this.bearID = bearID;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Cave getHome() {
		return home;
	}

	public void setHome(Cave home) {
		this.home = home;
	}

	public Honey getPotOfHoney() {
		return potOfHoney;
	}

	public void setPotOfHoney(Honey potOfHoney) {
		this.potOfHoney = potOfHoney;
	}

	public Set<Bear> getBearCubs() {
		return bearCubs;
	}

	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}

	
}
