package beans;

import java.util.HashMap;
import java.util.Map;

public enum ReimbursementStatus {
	PENDING(1), APPROVED(2), DENIED(3);
	
	private int id;
	
    private static final Map<Integer, ReimbursementStatus> statusId = new HashMap<>();
	
    static {
        for (ReimbursementStatus rs : ReimbursementStatus.values()) {
            statusId.put(rs.getId(), rs);
        }
    }

	ReimbursementStatus(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public static ReimbursementStatus getStatusById(int id) {
        ReimbursementStatus status = statusId.get(id);
        if (status == null) {
           throw new IllegalArgumentException("no such status");
        }
        return status;
    }
}
