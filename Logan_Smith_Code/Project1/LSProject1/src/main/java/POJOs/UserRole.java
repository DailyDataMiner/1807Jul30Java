package POJOs;

public class UserRole {

	private int userRoleID;
	private String userRoleName;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userRoleID;
		result = prime * result + ((userRoleName == null) ? 0 : userRoleName.hashCode());
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
		UserRole other = (UserRole) obj;
		if (userRoleID != other.userRoleID)
			return false;
		if (userRoleName == null) {
			if (other.userRoleName != null)
				return false;
		} else if (!userRoleName.equals(other.userRoleName))
			return false;
		return true;
	}
	public UserRole(int userRoleID, String userRoleName) {
		super();
		this.userRoleID = userRoleID;
		this.userRoleName = userRoleName;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
}
