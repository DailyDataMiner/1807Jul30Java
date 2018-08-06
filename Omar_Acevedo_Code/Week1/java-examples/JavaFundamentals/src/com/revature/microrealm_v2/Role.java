package com.revature.microrealm_v2;
import com.revature.helpers.HelperFunctions;

public abstract class Role extends HelperFunctions implements Roles {
	public abstract void action();
	
	public abstract void warrior();
	public abstract void hunter();
	public abstract void mage();
	public abstract void healer();
	
	public abstract void attack();
	
}
