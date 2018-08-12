package com.revature.util;

public enum AccountType {
	
	CHECKING("checking"), SAVINGS("savings"), COMMUNAL("communal"), GAMBLING("gambling"), ADMIN("admin");
	
	private final String text;
	
	AccountType(final String text){
		this.text = text;
	}
	
	@Override
    public String toString() {
        return text;
    }

}
