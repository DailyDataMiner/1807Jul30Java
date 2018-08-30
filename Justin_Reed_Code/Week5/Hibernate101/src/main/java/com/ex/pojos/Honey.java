package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity  //necessary
@Table(name="HONEYPOTS") //necessary only if you want to change the name default is class name
public class Honey {
	
	
	@Id @Column(name="HP_ID") 
	@SequenceGenerator(name="HP_ID_SEQ", sequenceName="HP_ID_SEQ")
	@GeneratedValue(generator="HP_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private double volume;
	@Column
	private String honey;
	public Honey(int id, double volume, String honey) {
		super();
		this.id = id;
		this.volume = volume;
		this.honey = honey;
	}
	public Honey() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getHoney() {
		return honey;
	}
	public void setHoney(String honey) {
		this.honey = honey;
	}
	@Override
	public String toString() {
		return "Honey [id=" + id + ", volume=" + volume + ", honey=" + honey + "]";
	}
	
	

}
