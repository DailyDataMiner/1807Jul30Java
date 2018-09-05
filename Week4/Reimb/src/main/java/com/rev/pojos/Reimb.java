package com.rev.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimb{

	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusid;
	private int typeid;
	
	private String sauthor;
	private String sresolver;
	private String sstatusid;
	private String stypeid;

	
	
	public Reimb() {}

	public Reimb(double amount, String description,
			Blob receipt, int author, int typeid) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.typeid = typeid;
	}
	
	public Reimb(double amount, String description,
			int author, int typeid) {
		super();
		this.amount = amount;
		this.description = description;
		this.author = author;
		this.typeid = typeid;
	}
	public Reimb(double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob receipt, int author, int resolver, int statusid, int typeid) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}
	
	public Reimb(double amount, Timestamp submitted, Timestamp resolved, String description,
			int author, int resolver, int statusid, int typeid) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}
	
	//mainly used for retrieval into object
	public Reimb(int id, double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob receipt, int author, int resolver, int statusid, int typeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}
	
	
	//returned with String instead of Id numbers
	public Reimb(int id, double amount, Timestamp submitted, Timestamp resolved, String description, 
			String sauthor, String sresolver, String sstatusid, String stypeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.sauthor = sauthor;
		this.sresolver = sresolver;
		this.sstatusid = sstatusid;
		this.stypeid = stypeid;
	}
	
	public String getSauthor() {
		return sauthor;
	}

	public void setSauthor(String sauthor) {
		this.sauthor = sauthor;
	}

	public String getSresolver() {
		return sresolver;
	}

	public void setSresolver(String sresolver) {
		this.sresolver = sresolver;
	}

	public String getSstatusid() {
		return sstatusid;
	}

	public void setSstatusid(String sstatusid) {
		this.sstatusid = sstatusid;
	}

	public String getStypeid() {
		return stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
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
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	@Override
	public String toString() {
		return "Reimb [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + sauthor + ", resolver="
				+ sresolver + ", statusid=" + sstatusid + ", typeid=" + stypeid + "]";
	}
	
	
	
}
