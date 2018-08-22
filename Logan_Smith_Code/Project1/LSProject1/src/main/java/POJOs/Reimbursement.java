package POJOs;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimbID;
	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDesc;
	private Blob reimbReceipt;
	private User reimbAuthor;
	private User reimbResolver;
	private ReimbStatus reimbStatus;
	private ReimbType reimbType;
	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDesc=" + reimbDesc + ", reimbReceipt="
				+ reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus="
				+ reimbStatus + ", reimbType=" + reimbType + "]";
	}
	public Reimbursement(int reimbID, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDesc,
			Blob reimbReceipt, User reimbAuthor, User reimbResolver, ReimbStatus reimbStatus, ReimbType reimbType) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDesc = reimbDesc;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	
	public int getReimbID() {
		return reimbID;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDesc() {
		return reimbDesc;
	}
	public void setReimbDesc(String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}
	public Blob getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public User getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public User getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(User reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public ReimbStatus getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(ReimbStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public ReimbType getReimbType() {
		return reimbType;
	}
	public void setReimbType(ReimbType reimbType) {
		this.reimbType = reimbType;
	}
}
