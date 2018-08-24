package beans;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 3155415736360056327L;

	private int id;
	private double amount;
	private Timestamp submittedTime;
	private Timestamp resolvedTime;
	private String description;
	private Blob receipt;
	private int authorId;
	private int resolverId;
	private ReimbursementStatus status;
	private ReimbursementType type;

	public Reimbursement() {
	}

	public Reimbursement(double amount, Timestamp submittedTime, String description, int authorId,
			ReimbursementStatus status, ReimbursementType type) {
		super();
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.description = description;
		this.authorId = authorId;
		this.status = status;
		this.type = type;
	}

	public Reimbursement(int id, double amount, Timestamp submittedTime, Timestamp resolvedTime, String description,
			Blob receipt, int authorId, int resolverId, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
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

	public void setReceipt(Blob blob) {
		this.receipt = blob;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submittedTime=" + submittedTime + ", resolvedTime="
				+ resolvedTime + ", description=" + description + ", authorId=" + authorId + ", resolverId="
				+ resolverId + ", status=" + status + ", type=" + type + "]";
	}

}
