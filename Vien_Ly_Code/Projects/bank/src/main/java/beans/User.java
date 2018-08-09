package beans;

import java.util.Collections;
import java.util.List;

public class User {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private byte[] passwordHash;
	private byte[] passwordSalt;
	private List<Account> accounts;
	
	public User(int id, String username, String firstName, String lastName, byte[] passwordHash, byte[] passwordSalt,
			List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
		this.accounts = accounts;
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
	public void setUsername(String username) {
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
	public byte[] getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public List<Account> getAccounts() {
		return Collections.unmodifiableList(this.accounts);
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
