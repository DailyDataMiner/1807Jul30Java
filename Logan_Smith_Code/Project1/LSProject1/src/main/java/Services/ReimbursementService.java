package Services;

import java.util.List;

import DAOs.ReimbStatusDAO;
import DAOs.ReimbursementDAO;
import POJOs.Reimbursement;
import POJOs.User;

public class ReimbursementService {
	static ReimbursementDAO rDao = new ReimbursementDAO();
	static ReimbStatusDAO rsDao = new ReimbStatusDAO();

	static public List<Reimbursement> getAll() {
		return rDao.findAll();
	}
	
	static public List<Reimbursement> getAllByStatus(int statusID) {
		return rDao.findAllByStatus(statusID);
	}
	
	static public List<Reimbursement> getAllByType(int typeID) {
		return rDao.findAllByType(typeID);
	}
	
	static public List<Reimbursement> getAllByAuthor(int authorID) {
		return rDao.findAllByAuthor(authorID);
	}
	
	static public List<Reimbursement> getAllByResolver(int resolverID) {
		return rDao.findAllByResolver(resolverID);
	}

	static public Reimbursement getOne(int input) {
		return rDao.findOne(input);
	}

	static public Reimbursement saveReimbursement(Reimbursement a) {
		return rDao.save(a);
	}

	static public void deleteReimbursement(Reimbursement a) {
		rDao.delete(a);
	}

	static public Reimbursement updateReimbursement(Reimbursement a, User iresolver, int iresolvedid) {
		a.setReimbResolver(iresolver);
		a.setReimbStatus(rsDao.findOne(iresolvedid));
		return rDao.updateReimbursementResolved(a);
	}
}
