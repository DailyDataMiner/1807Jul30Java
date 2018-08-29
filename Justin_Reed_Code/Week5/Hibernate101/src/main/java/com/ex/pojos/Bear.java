package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bears")

public class Bear {

	@Id
	@Column(name = "B_ID")
	@SequenceGenerator(name="B_SEQ_GEN", sequenceName="BEAR_SEQ")
	@GeneratedValue(generator="B_SEQ_GEN", strategy= GenerationType.SEQUENCE)
	private int bearId;

	@Column()
	private String furcolor;

	@Column()
	private double height;

	@Column(nullable = false)
	private String breed;

	public Bear() {
		super();
	}

	public Bear(int bearId, String furcolor, double height, String breed) {
		super();
		this.bearId = bearId;
		this.furcolor = furcolor;
		this.height = height;
		this.breed = breed;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getFurcolor() {
		return furcolor;
	}

	public void setFurcolor(String furcolor) {
		this.furcolor = furcolor;
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

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", furcolor=" + furcolor + ", height=" + height + ", breed=" + breed + "]";
	}

}
