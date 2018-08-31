package beans;

import java.sql.Blob;
import java.sql.Timestamp;

public class ReimbursementDetails {
	private int id;
	private double amount;
	private Timestamp submittedTime;
	private Timestamp resolvedTime;
	private String description;
	private Blob receipt;
	private String authorUsername;
	private String authorFirstName;
	private String authorLastName;
	private String resolverUsername;
	private String resolverFirstName;
	private String resolverLastName;
	private String status;
	private String type;

	public ReimbursementDetails() {
		super();
	}

	public ReimbursementDetails(int id, double amount, Timestamp submittedTime, Timestamp resolvedTime,
			String description, Blob receipt, String authorUsername, String authorFirstName, String authorLastName,
			String resolverUsername, String resolverFirstName, String resolverLastName, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.authorUsername = authorUsername;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.resolverUsername = resolverUsername;
		this.resolverFirstName = resolverFirstName;
		this.resolverLastName = resolverLastName;
		this.status = status;
		this.type = type;
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

	public Timestamp getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}

	public Timestamp getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(Timestamp resolvedTime) {
		this.resolvedTime = resolvedTime;
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

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getResolverUsername() {
		return resolverUsername;
	}

	public void setResolverUsername(String resolverUsername) {
		this.resolverUsername = resolverUsername;
	}

	public String getResolverFirstName() {
		return resolverFirstName;
	}

	public void setResolverFirstName(String resolverFirstName) {
		this.resolverFirstName = resolverFirstName;
	}

	public String getResolverLastName() {
		return resolverLastName;
	}

	public void setResolverLastName(String resolverLastName) {
		this.resolverLastName = resolverLastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
