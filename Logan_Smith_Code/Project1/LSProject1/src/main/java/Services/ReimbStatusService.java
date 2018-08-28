package Services;

import java.util.List;

import DAOs.ReimbStatusDAO;
import POJOs.ReimbStatus;

public class ReimbStatusService {
	static ReimbStatusDAO rsDao = new ReimbStatusDAO();

	public List<ReimbStatus> getAll() {
		return rsDao.findAll();
	}

	public ReimbStatus getOne(int input) {
		return rsDao.findOne(input);
	}

	public ReimbStatus saveReimbStatus(ReimbStatus a) {
		return rsDao.save(a);
	}

}
