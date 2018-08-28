package POJOs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReimbStatus {

	public ReimbStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int reimbStatusID;
	private String reimbStatusName;
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public String getReimbStatusName() {
		return reimbStatusName;
	}
	@Override
	public String toString() {
		return "ReimbStatus [reimbStatusID=" + reimbStatusID + ", reimbStatusName=" + reimbStatusName + "]";
	}
	public ReimbStatus(int reimbStatusID, String reimbStatusName) {
		super();
		this.reimbStatusID = reimbStatusID;
		this.reimbStatusName = reimbStatusName;
	}
	public void setReimbStatusName(String reimbStatusName) {
		this.reimbStatusName = reimbStatusName;
	}
	
}
