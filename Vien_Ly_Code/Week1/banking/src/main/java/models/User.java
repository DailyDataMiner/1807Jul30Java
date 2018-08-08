package models;

import java.util.List;

public class User {
	private String username;
	private String password;
	private List<Account> accounts;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.accounts = accounts;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public boolean addAccount(Account newAccount) {
		return accounts.add(newAccount);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}

}
