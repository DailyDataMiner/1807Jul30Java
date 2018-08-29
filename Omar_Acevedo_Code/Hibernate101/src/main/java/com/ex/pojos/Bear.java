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
	@GeneratedValue(generator="B_SEQ_GEN",strategy=GenerationType.SEQUENCE)
	private int bearId;
	
	@Column
	private String furColor;
	
	@Column
	private double height;
	
	@Column(nullable=false)
	private String breed;
	
//	RELATIONSHIPS
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="HONEY_POT")
	private Honey potOfHoney;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	// some annotation goes here
	@JoinColumn(name="BEAR_CAVE")
	private Cave home;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PARENT_CUB",
				joinColumns=@JoinColumn(name="PARENT_ID"),
				inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	
	private Set<Bear> bearCubs;
	
	public Bear() {}

	public Bear(String furColor, double height, String breed, Honey potOfHoney, Cave home,
			Set<Bear> bearCubs) {
		super();
		this.furColor = furColor;
		this.height = height;
		this.breed = breed;
		this.potOfHoney = potOfHoney;
		this.home = home;
		this.bearCubs = bearCubs;
	}
	
	public Bear(int bearId, String furColor, double height, String breed, Honey potOfHoney, Cave home,
			Set<Bear> bearCubs) {
		super();
		this.bearId = bearId;
		this.furColor = furColor;
		this.height = height;
		this.breed = breed;
		this.potOfHoney = potOfHoney;
		this.home = home;
		this.bearCubs = bearCubs;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
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

	public Honey getPotOfHoney() {
		return potOfHoney;
	}

	public void setPotOfHoney(Honey potOfHoney) {
		this.potOfHoney = potOfHoney;
	}

	public Cave getHome() {
		return home;
	}

	public void setHome(Cave home) {
		this.home = home;
	}

	public Set<Bear> getBearCubs() {
		return bearCubs;
	}

	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", furColor=" + furColor + ", height=" + height + ", breed=" + breed
				+ ", potOfHoney=" + potOfHoney + ", home=" + home + ", bearCubs=" + bearCubs + "]";
	}
	
}
