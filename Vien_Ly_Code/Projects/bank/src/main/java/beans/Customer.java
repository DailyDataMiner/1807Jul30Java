package beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5582002563443132161L;
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String passwordHash;
	private List<Account> accounts;
	
	public Customer(String username, String firstName, String lastName, String passwordHash) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
//		this.accounts = accounts;
	}
	
	public Customer(int id, String username, String firstName, String lastName, String passwordHash) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
//		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public List<Account> getAccounts() {
		return Collections.unmodifiableList(this.accounts);
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
}
