package POJOs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReimbType {

	public ReimbType() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int reimbTypeID;
	private String reimbTypeName;
	public int getReimbTypeID() {
		return reimbTypeID;
	}
	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	public String getReimbTypeName() {
		return reimbTypeName;
	}
	public void setReimbTypeName(String reimbTypeName) {
		this.reimbTypeName = reimbTypeName;
	}
	public ReimbType(int reimbTypeID, String reimbTypeName) {
		super();
		this.reimbTypeID = reimbTypeID;
		this.reimbTypeName = reimbTypeName;
	}
	@Override
	public String toString() {
		return "ReimbType [reimbTypeID=" + reimbTypeID + ", reimbTypeName=" + reimbTypeName + "]";
	}
	
}
