package beans;

import java.util.HashMap;
import java.util.Map;

public enum ReimbursementType {
	LODGING(1), TRAVEL(2), FOOD(3), OTHER(4);

	private int id;

	private static final Map<Integer, ReimbursementType> typeId = new HashMap<>();

	static {
		for (ReimbursementType rt : ReimbursementType.values()) {
			typeId.put(rt.getId(), rt);
		}
	}

	ReimbursementType(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static ReimbursementType getTypeById(int id) {
		ReimbursementType type = typeId.get(id);
		if (type == null) {
			throw new IllegalArgumentException("no such reimbursement type");
		}
		return type;
	}
}
