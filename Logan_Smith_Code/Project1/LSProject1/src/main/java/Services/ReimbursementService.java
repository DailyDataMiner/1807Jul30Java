package Services;

import java.util.List;

import DAOs.ReimbStatusDAO;
import DAOs.ReimbursementDAO;
import POJOs.Reimbursement;
import POJOs.User;

public class ReimbursementService {
	static ReimbursementDAO rDao = new ReimbursementDAO();
	static ReimbStatusDAO rsDao = new ReimbStatusDAO();

	public List<Reimbursement> getAll() {
		return rDao.findAll();
	}

	public Reimbursement getOne(int input) {
		return rDao.findOne(input);
	}

	public Reimbursement saveReimbursement(Reimbursement a) {
		return rDao.save(a);
	}

	public void deleteReimbursement(Reimbursement a) {
		rDao.delete(a);
	}

	public Reimbursement getByType(String type) {
		List<Reimbursement> reimbs = rDao.findAll();
		Reimbursement reimb = reimbs.stream().filter(x -> x.getReimbType().getReimbTypeName().equals(type)).findAny().orElse(null);
		return reimb;
	}
	
	public Reimbursement getByStatus(String status) {
		List<Reimbursement> reimbs = rDao.findAll();
		Reimbursement reimb = reimbs.stream().filter(x -> x.getReimbStatus().getReimbStatusName().equals(status)).findAny().orElse(null);
		return reimb;
	}

	public Reimbursement updateReimbursement(Reimbursement a, User iresolver, int iresolvedid) {
		a.setReimbResolver(iresolver);
		a.setReimbStatus(rsDao.findOne(iresolvedid));
		return rDao.updateReimbursementResolved(a);
	}
}
