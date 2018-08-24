package beans;

import java.util.HashMap;
import java.util.Map;

public enum UserRole {
	EMPLOYEE(1), MANAGER(2);

	private int id;
	private static final Map<Integer, UserRole> roleId = new HashMap<>();

	// associate an id with the user role to process after getting data from the database
	static {
		for (UserRole r : UserRole.values()) {
			roleId.put(r.getId(), r);
		}
	}

	UserRole(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static UserRole getRoleById(int id) {
		UserRole role = roleId.get(id);
		if (role == null) {
			throw new IllegalArgumentException("No such roles");
		}
		return role;
	}
}
