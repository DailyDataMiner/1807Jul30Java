package services;

import java.sql.Timestamp;
import java.util.List;

import DAO.ReimbursementDAO;
import beans.Reimbursement;
import beans.ReimbursementDetails;
import beans.ReimbursementStatus;
import beans.ReimbursementType;
import servlets.models.ReimbursementResolveData;

public class ReimbursementService {

	private ReimbursementDAO riDAO;

	public ReimbursementService() {
		this.riDAO = new ReimbursementDAO();
	}

	public List<Reimbursement> findAll() {
		return riDAO.findAll();
	}

	public Reimbursement findOne(int id) {
		return riDAO.findOne(id);
	}
	
	public ReimbursementDetails getDetails(int id) {
		return riDAO.getDetails(id);
	}

	public List<Reimbursement> findByAuthor(String username) {
		return riDAO.findAllByAuthor(username);
	}

	public List<Reimbursement> findByStatus(ReimbursementStatus status) {
		return riDAO.findAllByStatus(status);
	}

	public List<Reimbursement> findByType(ReimbursementType type) {
		return riDAO.findAllByType(type);
	}

	public boolean createReimbursement(Reimbursement ri) {
		return riDAO.insert(ri);
	}

	public boolean updateReimbursement(Reimbursement ri) {
		return riDAO.update(ri);
	}

	public boolean deleteReimbursement(Reimbursement ri) {
		return riDAO.delete(ri);
	}

	// Reimb_Resolved, Reimb_Resolver, Reimb_Status_Id
	public boolean resolve(Reimbursement ri, int resolverId, ReimbursementResolveData resolveData) {
		ri.setResolvedTime(new Timestamp(System.currentTimeMillis()));
		ri.setResolverId(resolverId);
		ri.setStatus(resolveData.getStatus());
		return riDAO.update(ri);
	}
}
