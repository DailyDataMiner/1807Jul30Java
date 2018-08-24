package services;

import java.sql.Timestamp;
import java.util.List;

import DAO.ReimbursementDAO;
import beans.Reimbursement;
import beans.ReimbursementStatus;
import beans.ReimbursementType;
import beans.User;

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
	public boolean resolve(Reimbursement ri, User resolver, boolean isApproved) {
		ri.setResolvedTime(new Timestamp(System.currentTimeMillis()));
		ri.setResolverId(resolver.getId());
		ri.setStatus(isApproved? ReimbursementStatus.APPROVED : ReimbursementStatus.DENIED);
		riDAO.update(ri);
		return isApproved;
	}
}
