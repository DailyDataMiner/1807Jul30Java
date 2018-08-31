package servlets.models;

import beans.ReimbursementStatus;

public class ReimbursementResolveData {
	private int id;
	private ReimbursementStatus status;

	public ReimbursementResolveData() {
		super();
	}

	public ReimbursementResolveData(int id, int resolverId, ReimbursementStatus status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReimbursementResolveData other = (ReimbursementResolveData) obj;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementResolveData [id=" + id + ", status=" + status + "]";
	}

}
