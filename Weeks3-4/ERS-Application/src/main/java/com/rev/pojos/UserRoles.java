package com.rev.pojos;

public class UserRoles {
	
	private int roleID;
	private String role;
	
	public UserRoles() {
		super();
	}

	public UserRoles(int roleID, String role) {
		super();
		this.roleID = roleID;
		this.role = role;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [roleID=" + roleID + ", role=" + role + "]";
	}
	
	

	
}
