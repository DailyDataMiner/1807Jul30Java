package com.revature.model;

import java.sql.Timestamp;

public class UpdateObject {


	private static int reimbbId;
	private Timestamp resolved;
	private String resolver;
	private static int status;
	
	public static int getReimbbId() {
		return reimbbId;
	}
	public void setReimbbId(int reimbbId) {
		this.reimbbId = reimbbId;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public static Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public UpdateObject(int reimbbId, Timestamp resolved, String resolver, int status) {
		super();
		this.reimbbId = reimbbId;
		this.resolved = resolved;
		this.resolver = resolver;
		this.status = status;
	}
	@Override
	public String toString() {
		return "UpdateObject [reimbbId=" + reimbbId + ", resolved=" + resolved + ", resolver=" + resolver + ", status="
				+ status + "]";
	}

	
}
