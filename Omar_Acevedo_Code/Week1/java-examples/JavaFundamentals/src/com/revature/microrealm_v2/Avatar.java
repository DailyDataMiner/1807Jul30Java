package com.revature.microrealm_v2;
//import com.revature.microrealm_v2.Role;

public class Avatar extends HumanBluePrint {
	
	private String role;
	
	public Avatar() {}
	public Avatar(String name, String gender) {
		this.setName(name);
		this.setGender(gender);
//		RoleActions a = new RoleActions();
		
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public /*static*/ void role() {
//	public /*static*/ void role(Role p_type) {
		print("...");
	}
	
}
