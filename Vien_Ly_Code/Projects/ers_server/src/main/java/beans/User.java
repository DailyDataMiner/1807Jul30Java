package beans;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import utils.Password;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	@JsonIgnore
	private byte[] pwdHash;
	@JsonIgnore
	private byte[] pwdSalt;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;

	public User() {
	}
	
	public User(String username, String password, String firstName, String lastName,
			String email, UserRole role) {
		super();
		this.username = username;
		this.pwdSalt = Password.getSalt();
		this.pwdHash = Password.getHash(password, pwdSalt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public User(String username, byte[] pwdHash, byte[] pwdSalt, String firstName, String lastName,
			String email, UserRole role) {
		super();
		this.username = username;
		this.pwdHash = pwdHash;
		this.pwdSalt = pwdSalt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public User(int id, String username, byte[] pwdHash, byte[] pwdSalt, String firstName, String lastName,
			String email, UserRole role) {
		super();
		this.id = id;
		this.username = username;
		this.pwdHash = pwdHash;
		this.pwdSalt = pwdSalt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
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

	public byte[] getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(byte[] pwdHash) {
		this.pwdHash = pwdHash;
	}

	public byte[] getPwdSalt() {
		return pwdSalt;
	}

	public void setPwdSalt(byte[] pwdSalt) {
		this.pwdSalt = pwdSalt;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwdHash=" + Arrays.toString(pwdHash) + ", pwdSalt="
				+ Arrays.toString(pwdSalt) + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + "]";
	}

}
